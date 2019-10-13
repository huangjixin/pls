Authorization Basic c2VjdXJpdHktc2VydmljZToxMjM0NTY=
用Base64进行加密（security-service:123456）

头部header:
Authorization 
Basic c2VjdXJpdHktc2VydmljZToxMjM0NTY=

body:
grant_type  password
username admin
password 123456

访问：http://ip:端口号/oauth/token

public static void main(String[] args) {
	String content = "security-service:123456";
	String encodeContent = Base64.getEncoder().encodeToString(content.getBytes());
	System.out.println(encodeContent);
	byte[] bs = Base64.getDecoder().decode(encodeContent);
	String res = new String(bs);
	System.out.println(res);
    Jwt jwt = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMxODQ2OTEzNDcsInVzZXJfbmFtZSI6IjEiLCJqdGkiOiJlYjQwNGY2YS1hMDViLTRhNjYtYTgzMS04OTFlNmQ0M2FlNjUiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.fGY9jPftqFbkhcv3Z66J77bNH1KIjO8C4X6ZMpyWp_8FWEBoLqz72uRChBbqsFVZIZe8LvppBGj7To6vafsEE-l6A_NM616zeGGUDhDPmBV0ymJIrWsNOGLT2WgFj5xrOYZvxsXuXjTcg_OiOKw7EcRFnbSZjlViHRZ9NBvxmHd1-I6m_Krms40JobwK5eyXZgSTm863Zc2GZXyFAIhxXHkG7erRPnHHZlueekSeNYd2w8QgNE_E59qEandYQ-SUW3Xs-zrWCImvaUgbh1It9Rgjpo1CWgJ5pVANQQt1uMiKlacbJ_-omS48RLUchmMsUb4jwtnClwYmM56b-KTiXw");
    System.out.println(jwt.getClaims());
}	

Token实例
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjMxOTIwMTY2MjIsInVzZXJfbmFtZSI6Imh1YW5nIiwiYXV0aG9yaXRpZXMiOlsiKiJdLCJqdGkiOiIwMDIwZjcxOS1hYzIwLTRkMTAtYjk2Mi0xYWRiMmMzODY4ZGQiLCJjbGllbnRfaWQiOiJzZWN1cml0eS1zZXJ2aWNlIiwic2NvcGUiOlsic2VydmljZSJdfQ.XC4HagBSu7iYFm71jlDmLzgo20PoSYEXgi2CV3Am7tvBdKTZfeR5Zubpnk4lnJB4rFuEdtyOAp9M3DHbgScfCu_giADIVEVFWzr2DwqyJ68WI0bbflcUV5eV34R4DeSmfK4mxDgLoCT4Q3ayfxZQLuUuTcVRZMyfItozFsW6BsyBpNI-kTM0Go2yTcJSKyfq4NEfU7hHO55e0NAbHvO1DzIhHhugdNMC_7f0dPlqHXMCQGTp7x1KivAiJ6xznrN8QfNadXZ1myLG6MCxE3rt4J2-jpGN-6sddyk2__ajT546qtoU_Ni7QN5Hd-Co4ojoVU_Afq8Whb9_ZaExLwbtiQ",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJodWFuZyIsInNjb3BlIjpbInNlcnZpY2UiXSwiYXRpIjoiMDAyMGY3MTktYWMyMC00ZDEwLWI5NjItMWFkYjJjMzg2OGRkIiwiZXhwIjoxNTU0MzQ2OTkwLCJhdXRob3JpdGllcyI6WyIqIl0sImp0aSI6IjIwYjM5YThhLWMyY2EtNGJlNi05MzY3LTYwYmM0OTFmNDhkYSIsImNsaWVudF9pZCI6InNlY3VyaXR5LXNlcnZpY2UifQ.DKD3ZLmSJc_Q3j-CrwoC1viAc4RGSbX2BwUM1_CtsE6WEspc_6NT06YCuDVbsQJnU9HaNv4fGH7ztcFBAaAdW8aNtwvZiBQxmBih831f3TMq6FO2LD_dOLlF_VVz003nHZ_EOnxFyrhvWY9atCw0LGdAdNcPnLOEGeXREs9WjbV4fyBzwKMh6iLPxAVPQCPlpygoG2bYbwoBj1-1NoAaI1tPpX8cGtl0tmg1cYK3zoRpVjm3gD2n1B7BPrpnz4g4iKr7810XC92i7UGiwP-a1Duma9rVeHsX1JwotW2VeBtn7JhdF90LeIL4Ufo0he2g8OpFILA8_62PC1UrF6NKcw",
    "expires_in": 1640261631,
    "scope": "service",
    "jti": "0020f719-ac20-4d10-b962-1adb2c3868dd"
}

SecurityContext securityContext = SecurityContextHolder.getContext();
    return securityContext.getAuthentication().getName();
    
  注解@PreAuthorize("hasAuthority('SYS_ADMIN')")

@RestController
@RequestMapping("test")
public class TestController {
	/**
	 * 测试方法
	 * @return
	 */
	@GetMapping("hello")
	@PreAuthorize("hasAuthority('*') or hasAuthority('test:hello')")
	public String hello() {
		return "hello,test";
	}
}

通过PostMan进行访问：
http://127.0.0.1:8928/mes/test/hello
header：
key:Authorization
Value:Bearer Token


// 请求过滤 对api/对所有接口都验证
        http
                .authorizeRequests()
                    .antMatchers("/api/**").access("@permissionChecker.hasPermission(authentication,request)")
                .anyRequest().authenticated();
 