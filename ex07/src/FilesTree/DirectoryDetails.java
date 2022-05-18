package FilesTree;

import java.util.LinkedList;
import java.util.List;

// TODO: Implement Composite (change this file).
public class DirectoryDetails extends FileDetails {
    List<FileDetails> files;
    public DirectoryDetails(String path, String name){
        super(path,name);
        files = new LinkedList<>();
    }

    @Override
    public void accept(FileVisitor visitor) {
        for (FileDetails file : files)
            file.accept(visitor);
        //visitor.visit(this);
    }

    public void addFile(FileDetails fileDetails){
        files.add(fileDetails);
    }
}