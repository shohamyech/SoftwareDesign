package FilesTree;

public interface FileVisitor {
    void visit(HtmlFileDetails html);
    void visit(DocxFileDetails docx);
    void visit(JpgFileDetails jpg);
    void visit(Mp3FileDetails mp3);
    void visit(PptxFileDetails pptx);
    void visit(TxtFileDetails txt);

    void visit(DirectoryDetails directoryDetails);
}
