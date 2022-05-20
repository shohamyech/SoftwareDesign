package FilesTree;
public abstract class FileDetails {
    protected String name;
    private String path;

    public FileDetails(String path, String fileName) {
        this.path= path==null?"":path.substring(0, path.length()-1);
        this.name = fileName;
    }
    public String getName() {
        return name;
    }

    public String getFullName(){
        return (path.isEmpty()?"":path+"/")+name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }

    public abstract void accept(FileVisitor visitor);

}
