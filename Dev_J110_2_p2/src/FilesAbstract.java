
public abstract class FilesAbstract {
    
    private String fileName;
    private long fileSize;

    public FilesAbstract(String fileName, long fileSize) {
        setFileName(fileName);
        setFileSize(fileSize);
    }

    public String getFileName() {
        return fileName;
    }

    public final void setFileName(String fileName) {
        if(fileName == null)
            throw new IllegalArgumentException("Необходимо указать имя файла.");
        
        this.fileName = fileName;
    }

    public long getFileSize() {       
        return fileSize;
    }

    public final void setFileSize(long fileSize) {
        if(fileSize <= 0)
            throw new IllegalArgumentException("Размер файла должен быть больше ноля.");
        
        this.fileSize = fileSize;
    }
    
    public static void printAll(FilesAbstract[] files) {
        
        System.out.println("              File name           |    Size    |                                          Details");
        System.out.println(".........................................................................................................................................................................................................");
        for(FilesAbstract file : files) {
            if(file instanceof TextFiles)
               System.out.printf("%26s.%s  | %-10d | Text. Pages:%s%n", file.getFileName(), ((TextFiles) file).getTextFileFormat(), file.getFileSize(), ((TextFiles) file).getNumberOfPages());
            
            else if(file instanceof ImageFiles)
               System.out.printf("%26s.%s   | %-10d | Image. Image size: %dx%d%n", file.getFileName(), ((ImageFiles) file).getImageFileFormat(), file.getFileSize(), ((ImageFiles) file).getImageSize().getImageFileWidth(), 
                                ((ImageFiles) file).getImageSize().getImageFileHeight()); 
            
            else if(file instanceof MediaFiles && !(file instanceof VideoFiles))
               System.out.printf("%26s.%s  | %-10d | Audio. %s, track duration - %02d:%02d:%02d%n", file.getFileName(), ((MediaFiles) file).getMediafileFormat(), file.getFileSize(), ((MediaFiles) file).getMediaFileDescription(), 
                                ((MediaFiles) file).getMediaDuration().hour, ((MediaFiles) file).getMediaDuration().minute, ((MediaFiles) file).getMediaDuration().second);
            else
               System.out.printf("%26s.%s   | %-10d | Video. %s, track duration - %02d:%02d:%02d, video resolution: %dx%d%n", file.getFileName(), ((VideoFiles) file).getMediafileFormat(), file.getFileSize(), ((VideoFiles) file).getMediaFileDescription(),
                                ((VideoFiles) file).getMediaDuration().hour, ((VideoFiles) file).getMediaDuration().minute, ((VideoFiles) file).getMediaDuration().second, ((VideoFiles) file).getVideoResolution().getVideoFrameWidth(), 
                                ((VideoFiles) file).getVideoResolution().getVideoFrameHeight()); 
      }
        System.out.println(".............................................................................................................................................................................................................");
  }
        public abstract void print(); 
}
