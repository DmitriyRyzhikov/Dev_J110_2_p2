
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
        if (fileName != null && !fileName.trim().isEmpty()) 
            this.fileName = fileName.trim();
        else
            throw new IllegalArgumentException("Необходимо указать имя файла.");
        
    }

    public long getFileSize() {       
        return fileSize;
    }

    public final void setFileSize(long fileSize) {
        if(fileSize > 0)
            this.fileSize = fileSize;
        else
           throw new IllegalArgumentException("Размер файла должен быть больше ноля.");        
    }
    
    //В одном из классов реализуйте статический метод printAll, печатающий данные о файлах из заданного массива. Данные должны выводиться в таблицу
    
    public static void printAll(FilesAbstract[] files) {
    //конструкция с методом concat() нужна, чтобы объединить в одно целое имя файла, его формат и точку, разделяющую их. Без этого плывут по ширине разделители столбцов.    
        System.out.println("              File name         |    Size    |                                          Details");
        System.out.println(".........................................................................................................................................................................................................");
        for(FilesAbstract file : files) {
            if(file instanceof TextFiles)
               System.out.printf("%30s  | %10d | Text. Pages:%s%n", file.getFileName().concat(".").concat(((TextFiles) file).getTextFileFormat()), file.getFileSize(), ((TextFiles) file).getNumberOfPages());
            
            else if(file instanceof ImageFiles)
               System.out.printf("%30s  | %10d | Image. Image size: %dx%d%n", file.getFileName().concat(".").concat(((ImageFiles) file).getImageFileFormat()), file.getFileSize(), ((ImageFiles) file).getImageSize().getImageFileWidth(), 
                                ((ImageFiles) file).getImageSize().getImageFileHeight()); 
            
            else if(file instanceof MediaFiles && !(file instanceof VideoFiles))
               System.out.printf("%30s  | %10d | Audio. %s, track duration - %02d:%02d:%02d%n", file.getFileName().concat(".").concat(((MediaFiles) file).getMediafileFormat()), file.getFileSize(), ((MediaFiles) file).getMediaFileDescription(), 
                                ((MediaFiles) file).getMediaDuration().getHour(), ((MediaFiles) file).getMediaDuration().getMinute(), ((MediaFiles) file).getMediaDuration().getSecond());
            else
               System.out.printf("%30s  | %10d | Video. %s, track duration - %02d:%02d:%02d, video resolution: %dx%d%n", file.getFileName().concat(".").concat(((VideoFiles) file).getMediafileFormat()), file.getFileSize(), ((VideoFiles) file).getMediaFileDescription(),
                                ((VideoFiles) file).getMediaDuration().getHour(), ((VideoFiles) file).getMediaDuration().getMinute(), ((VideoFiles) file).getMediaDuration().getSecond(), ((VideoFiles) file).getVideoResolution().getVideoFrameWidth(), 
                                ((VideoFiles) file).getVideoResolution().getVideoFrameHeight()); 
      }
        System.out.println(".............................................................................................................................................................................................................");
  }
       //методы, при помощи которых можно напечатать строковое представление размера изображения и длительности медиа файла   
        public abstract void printFeatures(); 
}
