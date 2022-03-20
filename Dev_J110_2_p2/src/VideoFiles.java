
public class VideoFiles extends MediaFiles {
    
    VideoResolution videoResolution;

    public VideoFiles(String fileName, long fileSize, String mediafileFormat, String mediaFileDescription, int hour, int minute, int second, int VideoFrameWidth, int VideoFrameHeight) {
        super(fileName, fileSize, mediafileFormat, mediaFileDescription, hour, minute, second);
        videoResolution = new VideoResolution(VideoFrameWidth, VideoFrameHeight);
    }
    public VideoResolution getVideoResolution() {
        return videoResolution;
    }
    public void setVideoResolution(VideoResolution videoResolution) {
        if(videoResolution == null)
            throw new IllegalArgumentException("Ссылка на объект <videoResolution> не должна быть пустой.");
        this.videoResolution = videoResolution;
    }
    @Override
    public void print() {
        System.out.printf("Длительность видеофайла %s составляет - часов:%02d, минут:%02d, секунд:%02d. Разрешение видео составляет: %dx%d%n", super.getFileName(), super.getMediaDuration().hour, 
                          super.getMediaDuration().minute, super.getMediaDuration().second, videoResolution.VideoFrameWidth, videoResolution.VideoFrameHeight);
    }
       
    public static class VideoResolution {
        
        private int VideoFrameWidth;
        private int VideoFrameHeight;

        public VideoResolution(int VideoFrameWidth, int VideoFrameHeight) {
            setVideoFrameWidth(VideoFrameWidth);
            setVideoFrameHeight(VideoFrameHeight);
        }
        public int getVideoFrameWidth() {
            return VideoFrameWidth;
        }
        public final void setVideoFrameWidth(int VideoFrameWidth) {
            if(VideoFrameWidth <= 0)
               throw new IllegalArgumentException("Ширина кадра в видеофайле должна быть больше ноля.");
        
            this.VideoFrameWidth = VideoFrameWidth;
        }
        public int getVideoFrameHeight() {
            return VideoFrameHeight;
        }
        public final void setVideoFrameHeight(int VideoFrameHeight) {
            if(VideoFrameHeight <= 0)
               throw new IllegalArgumentException("Высота кадра в видеофайле должна быть больше ноля.");
        
            this.VideoFrameHeight = VideoFrameHeight;
        }
    }    
}
