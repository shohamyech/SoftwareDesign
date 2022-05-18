package FilesTree;

public class StatisticsVisitor implements FileVisitor {
    @Override
    public void visit(HtmlFileDetails html) {
        System.out.println("The file " + html.getName() + " contains " + html.getLines() + " lines.");
    }

    @Override
    public void visit(DocxFileDetails docx) {
        System.out.println("The file " + docx.getName() + " has an average of " +
                docx.getWords() / docx.getPages() + " words per page.");
    }

    @Override
    public void visit(JpgFileDetails jpg) {
        System.out.println("The picture " + jpg.getName() + " has an average of " +
                Math.round((float) jpg.getSize() / (jpg.getHeight() * jpg.getWidth())) + " bytes per pixel.");
    }

    @Override
    public void visit(Mp3FileDetails mp3) {
        System.out.println("The bitrate of " + mp3.getName() + " is " +
                mp3.getSize() / mp3.getLengthSec() + " bytes per second.");
    }

    @Override
    public void visit(PptxFileDetails pptx) {
        System.out.println("The average slide size in Presentation " + pptx.getName() + " is " +
                pptx.getSize() / pptx.getSlides() + ".");
    }

    @Override
    public void visit(TxtFileDetails txt) {
        System.out.println("The file " + txt.getName() + " contains " +
                txt.getWords() + " words.");
    }

    @Override
    public void visit(DirectoryDetails directory) {
        CountVisitor countVisitor = new CountVisitor();
        directory.accept(countVisitor);
        System.out.println("Directory " + directory.getName() + " has " +
                countVisitor.getNumOfFiles() + " files.");
    }
}
