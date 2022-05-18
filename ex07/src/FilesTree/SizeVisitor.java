package FilesTree;

public class SizeVisitor implements FileVisitor{
    private int totalSize = 0;

    @Override
    public void visit(HtmlFileDetails html) {
        totalSize += html.getSize();
    }

    @Override
    public void visit(DocxFileDetails docx) {
        totalSize += docx.getSize();
    }

    @Override
    public void visit(JpgFileDetails jpg) {
        totalSize += jpg.getSize();
    }

    @Override
    public void visit(Mp3FileDetails mp3) {
        totalSize += mp3.getSize();
    }

    @Override
    public void visit(PptxFileDetails pptx) {
        totalSize += pptx.getSize();
    }

    @Override
    public void visit(TxtFileDetails txt) {
        totalSize += txt.getSize();
    }

    public int getTotalSize() {
        return totalSize;
    }
}
