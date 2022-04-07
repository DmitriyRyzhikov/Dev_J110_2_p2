
public class VideoFiles extends MediaFiles {
    
    private VideoResolution videoResolution;

    public VideoFiles(String fileName, long fileSize, String mediafileFormat, String mediaFileDescription, int hour, int minute, int second, int VideoFrameWidth, int VideoFrameHeight) {
        super(fileName, fileSize, mediafileFormat, mediaFileDescription, hour, minute, second);
        setVideoResolution(new VideoResolution(VideoFrameWidth, VideoFrameHeight));
    }
    public VideoResolution getVideoResolution() {
        return videoResolution;
    }
    public final void setVideoResolution(VideoResolution videoResolution) {
        if(videoResolution != null)
           this.videoResolution = videoResolution;
        else
           throw new IllegalArgumentException("Ссылка на объект <videoResolution> не должна быть пустой.");
    }
    
    //методы, при помощи которых можно напечатать строковое представление размера изображения и длительности медиа файла   
    @Override
    public void printFeatures() {
        System.out.printf("Длительность видеофайла %s составляет - часов:%02d, минут:%02d, секунд:%02d. Разрешение видео составляет: %dx%d%n", super.getFileName(), super.getMediaDuration().getHour(), 
                          super.getMediaDuration().getMinute(), super.getMediaDuration().getSecond(), videoResolution.VideoFrameWidth, videoResolution.VideoFrameHeight);
    }
    
    //вложенный класс VideoResolution для хранения данных о разрешении видеофайла
    
    public class VideoResolution {
        
        private int VideoFrameWidth;
        private int VideoFrameHeight;

        public VideoResolution(int VideoFrameWidth, int VideoFrameHeight) {
            
            setVideoFrameWidth(VideoFrameWidth);
            setVideoFrameHeight(VideoFrameHeight);
        }
        
        //getter’ы для полей класса VideoResolution
        public int getVideoFrameWidth() {
            return VideoFrameWidth;
        }
        
        public int getVideoFrameHeight() {
            return VideoFrameHeight;
        }
        
        //setter’ы для полей класса VideoResolution
        
        public final void setVideoFrameWidth(int VideoFrameWidth) {
            
            if(VideoFrameWidth > 0)
               this.VideoFrameWidth = VideoFrameWidth; 
            else
               throw new IllegalArgumentException("Ширина кадра в видеофайле должна быть больше ноля.");        
        }
               
        public final void setVideoFrameHeight(int VideoFrameHeight) {
            
            if(VideoFrameHeight > 0)
               this.VideoFrameHeight = VideoFrameHeight;
            else
               throw new IllegalArgumentException("Высота кадра в видеофайле должна быть больше ноля.");
        
        }
    }    
}
