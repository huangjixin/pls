mvn clean package -Dmaven.test.skip=true mybatis-generator:generator 

在service层中调用
int page = 1;
int size = 5;
PageHelper.startPage(page,size);    //只生效一次。做两次sql查询，总数查询一次，分页查询一次
List<User> users =  userMapper.findAll();
PageInfo<User> pageInfo = new PageInfo<User>(users);


https://github.com/abel533/Mapper/wiki/6.example
六、Example 用法
通用 Mapper 中的 Example 方法有两大类定义，一个参数和两个参数的，例如下面两个：

List<T> selectByExample(Object example);

int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);
所有 Example 方法中的 example 类型都是 Object 类型，这是因为通用 Mapper 支持所有符合 Example 结构的参数，例如通过 MBG 生成的 CountryExample、UserExample 类。还有通用 Mapper 中提供的通用 Example，以及支持 Java8 方法引用的 Weekend 类型。

配置中有一个和 Example 有关的参数，点击查看 3.14 checkExampleEntityClass。

6.1 MBG 生成的 Example
用法如下：

CountryExample example = new CountryExample();
example.createCriteria().andCountrynameLike("A%");
example.or().andIdGreaterThan(100);
example.setDistinct(true);
int count = mapper.deleteByExample(example);
对于的 SQL 日志如下：

DEBUG [main] - ==>  Preparing: DELETE FROM country WHERE ( countryname like ? ) or ( Id > ? ) 
DEBUG [main] - ==> Parameters: A%(String), 100(Integer)
DEBUG [main] - <==    Updates: 95
生成的 CountryExample 中包含了和字段相关的多种方法，根据自己的需要设置相应的条件即可。

6.2 通用 Example
这是由通用 Mapper 提供的一个类，这个类和 MBG 生成的相比，需要自己设置属性名。这个类还额外提供了更多的方法。

6.2.1 查询
示例：

Example example = new Example(Country.class);
example.setForUpdate(true);
example.createCriteria().andGreaterThan("id", 100).andLessThan("id",151);
example.or().andLessThan("id", 41);
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT id,countryname,countrycode FROM country WHERE ( id > ? and id < ? ) or ( id < ? ) ORDER BY id desc FOR UPDATE 
DEBUG [main] - ==> Parameters: 100(Integer), 151(Integer), 41(Integer)
DEBUG [main] - <==      Total: 90
6.2.2 动态 SQL
示例：

Example example = new Example(Country.class);
Example.Criteria criteria = example.createCriteria();
if(query.getCountryname() != null){
    criteria.andLike("countryname", query.getCountryname() + "%");
}
if(query.getId() != null){
    criteria.andGreaterThan("id", query.getId());
}
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT id,countryname,countrycode FROM country WHERE ( countryname like ? ) ORDER BY id desc 
DEBUG [main] - ==> Parameters: China%(String)
DEBUG [main] - <==      Total: 1
6.2.3 排序
示例：

Example example = new Example(Country.class);
example.orderBy("id").desc().orderBy("countryname").orderBy("countrycode").asc();
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT id,countryname,countrycode FROM country order by id DESC,countryname,countrycode ASC 
DEBUG [main] - ==> Parameters: 
DEBUG [main] - <==      Total: 183
6.2.4 去重
示例：

CountryExample example = new CountryExample();
//设置 distinct
example.setDistinct(true);
example.createCriteria().andCountrynameLike("A%");
example.or().andIdGreaterThan(100);
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT distinct id,countryname,countrycode FROM country WHERE ( countryname like ? ) or ( Id > ? ) ORDER BY id desc 
DEBUG [main] - ==> Parameters: A%(String), 100(Integer)
DEBUG [main] - <==      Total: 95
6.2.5 设置查询列
示例：

Example example = new Example(Country.class);
example.selectProperties("id", "countryname");
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT id , countryname FROM country ORDER BY id desc 
DEBUG [main] - ==> Parameters: 
DEBUG [main] - <==      Total: 183
除了这里提到的方法外，还有很多其他的方法，可以查看 Example 源码进行了解。

6.3 Example.builder 方式
示例：

Example example = Example.builder(Country.class)
        .select("countryname")
        .where(Sqls.custom().andGreaterThan("id", 100))
        .orderByAsc("countrycode")
        .forUpdate()
        .build();
List<Country> countries = mapper.selectByExample(example);
日志：

DEBUG [main] - ==>  Preparing: SELECT countryname FROM country WHERE ( id > ? ) order by countrycode Asc FOR UPDATE 
DEBUG [main] - ==> Parameters: 100(Integer)
DEBUG [main] - <==      Total: 83
6.4 Weekend
使用 6.2 和 6.3 中的 Example 时，需要自己输入属性名，例如 "countryname"，假设输入错误，或者数据库有变化，这里很可能就会出错，因此基于 Java 8 的方法引用是一种更安全的用法，如果你使用 Java 8，你可以试试 Weekend。

示例：

List<Country> selectByWeekendSql = mapper.selectByExample(new Example.Builder(Country.class)
        .where(WeekendSqls.<Country>custom().andLike(Country::getCountryname, "%a%")
                .andGreaterThan(Country::getCountrycode, "123"))
        .build());
日志：

DEBUG [main] - ==>  Preparing: SELECT id,countryname,countrycode FROM country WHERE ( countryname like ? and countrycode > ? ) 
DEBUG [main] - ==> Parameters: %a%(String), 123(String)
DEBUG [main] - <==      Total: 151
在代码中的 Country::getCountryname 就是方法引用，通过该方法可以自动转换对应的列名。