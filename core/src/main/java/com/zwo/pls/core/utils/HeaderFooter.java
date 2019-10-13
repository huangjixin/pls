package com.zwo.pls.core.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

class HeaderFooter extends PdfPageEventHelper {

    /**
     * 文档字体大小，页脚页眉最好和文本大小一致
     */
    public int fontSize = 10;

    // 模板
    private PdfTemplate total;

    private BaseFont bf;

    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle rect = writer.getBoxSize("art");
            /*switch(writer.getPageNumber() % 2) {
                case 0:
                    ColumnText.showTextAligned(writer.getDirectContent(),
                            Element.ALIGN_RIGHT, new Phrase("even header"),
                            rect.getRight(), rect.getTop(), 0);
                    break;
                case 1:
                    ColumnText.showTextAligned(writer.getDirectContent(),
                            Element.ALIGN_LEFT, new Phrase("odd header"),
                            rect.getLeft(), rect.getTop(), 0);
                    break;
            }*/
        try {
            bf = BaseFont.createFont(HeaderFooter.class.getClassLoader().getResource("ftl//simsun.ttc").getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("第%d页,", writer.getPageNumber()), new Font(bf, fontSize)),
                    (rect.getLeft() + rect.getRight()) / 2 - 12F, rect.getBottom() - 38, 0);

            PdfContentByte cb = writer.getDirectContent();
            cb.addTemplate(total, (rect.getLeft() + rect.getRight()) / 2 + 2F, rect.getBottom() - 38.5);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO 文档打开时创建模板
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(50, 50);// 共 页 的矩形的长宽高
    }

    /**
     * TODO 关闭文档时，替换模板，完成整个页眉页脚组件
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        // 7.最后一步了，就是关闭文档的时候，将模板替换成实际的 Y 值,至此，page x of y 制作完毕，完美兼容各种文档size。
        total.beginText();
        total.setFontAndSize(bf, fontSize);// 生成的模版的字体、颜色
        String foot2 = "共" + (writer.getPageNumber()) + "页";
        total.showText(foot2);// 模版显示的内容
        total.endText();
        total.closePath();
    }
}