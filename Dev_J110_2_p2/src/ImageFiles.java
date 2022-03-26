
public class ImageFiles extends FilesAbstract {
    
    private String imageFileFormat;
    private ImageSize imageSize;

    public ImageFiles(String fileName, long fileSize, String imageFileFormat, int imageFileWidth, int imageFileHeight) {
        super(fileName, fileSize);
        setImageFileFormat(imageFileFormat);
        setImageSize(new ImageSize(imageFileWidth, imageFileHeight));
    }
    public String getImageFileFormat() {
        return imageFileFormat;
    }
    public final void setImageFileFormat(String imageFileFormat) {
        if (imageFileFormat != null && !imageFileFormat.trim().isEmpty())
            this.imageFileFormat = imageFileFormat.trim(); 
        else
            throw new IllegalArgumentException("Необходимо указать формат файла.");
        
    }    
    public ImageSize getImageSize() {        
        return imageSize;
    }
    public final void setImageSize(ImageSize imageSize) {
        if(imageSize != null)
            this.imageSize = imageSize;
        else
            throw new IllegalArgumentException("Ссылка на объект <imageSize> не должна быть пустой");
        
    }
    
        //методы, при помощи которых можно напечатать строковое представление размера изображения и длительности медиа файла   
        @Override
        public void printFeatures() {   
            System.out.printf("Размер изображения, хранящегося в файле %s составляет %dx%d%n", super.getFileName(), imageSize.imageFileWidth, imageSize.imageFileHeight);
    }
  //вложенный класс ImageSize для хранения данных о размере картинки      
public class ImageSize {
    
    private int imageFileWidth;
    private int imageFileHeight;

    public ImageSize(int imageFileWidth, int imageFileHeight) {        
        setImageFileWidth(imageFileWidth);
        setImageFileHeight(imageFileHeight);
        }
        public int getImageFileWidth() {
            return imageFileWidth;
        }
        
        public final void setImageFileWidth(int imageFileWidth) {
            if(imageFileWidth > 0)
               this.imageFileWidth = imageFileWidth;
            else
                throw new IllegalArgumentException("Ширина изображения в файле должна быть больше ноля.");           
        }
        
        public int getImageFileHeight() {
            return imageFileHeight;
        }
        public final void setImageFileHeight(int imageFileHeight) {
            if(imageFileHeight > 0)
               this.imageFileHeight = imageFileHeight; 
            else   
               throw new IllegalArgumentException("Высота изображения в файле должна быть больше ноля.");
               
        } 
        public void printImageSize() {
            System.out.printf("Размер изображения в фале %s составляет %dx%d", ImageFiles.super.getFileName(), imageFileWidth, imageFileHeight);
    }
}
}

