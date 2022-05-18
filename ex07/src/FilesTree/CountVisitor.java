package FilesTree;

public class CountVisitor implements FileVisitor {

    private int numOfFiles = 0;

    @Override
    public void visit(HtmlFileDetails html) {
        numOfFiles += 1;
    }

    @Override
    public void visit(DocxFileDetails docx) {
        numOfFiles += 1;
    }

    @Override
    public void visit(JpgFileDetails jpg) {
        numOfFiles += 1;
    }

    @Override
    public void visit(Mp3FileDetails mp3) {
        numOfFiles += 1;
    }

    @Override
    public void visit(PptxFileDetails pptx) {
        numOfFiles += 1;
    }

    @Override
    public void visit(TxtFileDetails txt) {
        numOfFiles += 1;
    }

    @Override
    public void visit(DirectoryDetails directoryDetails) {
    }

    public int getNumOfFiles() {
        return numOfFiles;
    }
}
