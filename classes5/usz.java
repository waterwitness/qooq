import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.av.mediacodec.AndroidCodec.BufferData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.videoconverter.InputSurface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.OutputSurface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class usz
  implements Runnable
{
  long jdField_a_of_type_Long;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  ShortVideoCodec jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec;
  InputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface;
  OutputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface;
  VideoConverter.Processor jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor;
  File jdField_a_of_type_JavaIoFile;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  ShortVideoCodec jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec;
  boolean jdField_b_of_type_Boolean;
  long c;
  
  public usz(usy paramusy, File paramFile, VideoConverter.Processor paramProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor = null;
    this.jdField_a_of_type_JavaIoFile = null;
    this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = null;
    this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface = null;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface = null;
    this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.c = -1L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor = paramProcessor;
  }
  
  int a(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  MediaCodecInfo a(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  ShortVideoCodec a(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    Object localObject = ShortVideoCodec.a(paramMediaFormat.getString("mime"), false);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (MediaCodecInfo)((List)localObject).get(0);
      ShortVideoCodec localShortVideoCodec = new ShortVideoCodec();
      localShortVideoCodec.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
      localShortVideoCodec.a();
      return localShortVideoCodec;
    }
    return null;
  }
  
  ShortVideoCodec a(MediaFormat paramMediaFormat, AtomicReference paramAtomicReference)
  {
    ShortVideoCodec localShortVideoCodec = new ShortVideoCodec();
    localShortVideoCodec.a(paramMediaFormat, ShortVideoCodec.jdField_a_of_type_Int, null);
    paramAtomicReference.set(localShortVideoCodec.a().createInputSurface());
    localShortVideoCodec.a();
    return localShortVideoCodec;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "shutting down encoder, decoder");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.d();
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec.e();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, ShortVideoCodec paramShortVideoCodec1, ShortVideoCodec paramShortVideoCodec2, MediaMuxer paramMediaMuxer, InputSurface paramInputSurface, OutputSurface paramOutputSurface)
  {
    int i1 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    long l2 = 0L;
    int i = 0;
    int i3 = 0;
    MediaFormat localMediaFormat1 = null;
    int m = -1;
    MediaFormat localMediaFormat2 = null;
    long l3 = -1L;
    int j = 0;
    int k = 0;
    int n = -1;
    long l1 = 0L;
    Object localObject;
    label133:
    label138:
    int i4;
    label171:
    label218:
    long l5;
    int i2;
    if (((this.jdField_b_of_type_Boolean) && (i == 0)) || ((this.jdField_a_of_type_Boolean) && (j == 0)))
    {
      if ((!this.jdField_a_of_type_Boolean) || (j != 0) || ((localMediaFormat2 != null) && (i1 == 0))) {
        break label1144;
      }
      if ((localMediaFormat2 != null) && (i1 != 0))
      {
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
        if (((MediaCodec.BufferInfo)localObject).size < 0)
        {
          j = 1;
          if (j != 0) {}
          if ((l2 < l1) && (l1 - l2 > 0L) && (j == 0) && (this.jdField_a_of_type_Boolean)) {
            break label550;
          }
          i4 = 1;
          if ((!this.jdField_b_of_type_Boolean) || (k != 0) || ((localMediaFormat1 != null) && (i1 == 0)) || (i4 == 0)) {
            break label1138;
          }
          localObject = paramShortVideoCodec1.a();
          if (localObject == null) {
            break label1138;
          }
          if (((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int != -1) {
            break label556;
          }
          l5 = l3;
          i2 = i3;
          if (this.jdField_b_of_type_Boolean)
          {
            l5 = l3;
            i2 = i3;
            if (i3 == 0) {
              if (localMediaFormat1 != null)
              {
                l5 = l3;
                i2 = i3;
                if (i1 == 0) {}
              }
              else
              {
                l5 = l3;
                i2 = i3;
                if (i4 != 0)
                {
                  localObject = paramShortVideoCodec1.b();
                  if (localObject != null) {
                    break label695;
                  }
                  i2 = i3;
                  l5 = l3;
                }
              }
            }
          }
          label296:
          if ((!this.jdField_b_of_type_Boolean) || (i != 0) || ((localMediaFormat1 != null) && (i1 == 0)) || (i4 == 0)) {
            break label1129;
          }
          localObject = paramShortVideoCodec2.b();
          if (localObject != null) {
            break label948;
          }
          label335:
          if ((i1 != 0) || ((this.jdField_a_of_type_Boolean) && (localMediaFormat2 == null)) || ((this.jdField_b_of_type_Boolean) && (localMediaFormat1 == null))) {
            break label1153;
          }
          if (!this.jdField_b_of_type_Boolean) {
            break label1150;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
          }
          n = paramMediaMuxer.addTrack(localMediaFormat1);
          label394:
          if (!this.jdField_a_of_type_Boolean) {
            break label1147;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
          }
          m = paramMediaMuxer.addTrack(localMediaFormat2);
          label424:
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
          }
          paramMediaMuxer.start();
          i1 = 1;
        }
      }
    }
    label550:
    label556:
    label596:
    label616:
    label689:
    label695:
    label948:
    label1129:
    label1138:
    label1141:
    label1144:
    label1147:
    label1150:
    label1153:
    for (;;)
    {
      l3 = l5;
      i3 = i2;
      break;
      ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
      ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
      paramMediaMuxer.writeSampleData(m, localByteBuffer, (MediaCodec.BufferInfo)localObject);
      if (!paramMediaExtractor2.advance()) {}
      for (j = 1;; j = 0)
      {
        l2 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
        if ((this.c <= 0L) || (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.c)) {
          break label1141;
        }
        j = 1;
        break;
      }
      localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
      break label138;
      i4 = 0;
      break label171;
      int i5 = paramMediaExtractor1.readSampleData(((AndroidCodec.BufferData)localObject).jdField_a_of_type_JavaNioByteBuffer, 0);
      long l4 = paramMediaExtractor1.getSampleTime();
      if (this.c > 0L) {
        if (l4 >= this.c) {
          k = 1;
        }
      }
      for (;;)
      {
        if (i5 >= 0)
        {
          int i6 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
          if (k != 0)
          {
            i2 = 4;
            paramShortVideoCodec1.a(i6, i5, l4, i2);
          }
        }
        else
        {
          if (paramMediaExtractor1.advance()) {
            break label689;
          }
        }
        for (i2 = 1;; i2 = 0)
        {
          if (k != 0) {
            i2 = 1;
          }
          k = i2;
          if (i2 == 0) {
            break;
          }
          paramShortVideoCodec1.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int, 0, 0L, 4);
          k = i2;
          break;
          k = 0;
          break label596;
          i2 = paramMediaExtractor1.getSampleFlags();
          break label616;
        }
        MediaCodec.BufferInfo localBufferInfo = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i5 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
        l5 = l3;
        i2 = i3;
        if (i5 == -1) {
          break label296;
        }
        l5 = l3;
        i2 = i3;
        if (i5 == -3) {
          break label296;
        }
        if (i5 == -2)
        {
          paramShortVideoCodec1.a().getOutputFormat();
          l5 = l3;
          i2 = i3;
          break label296;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          paramShortVideoCodec1.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
          l5 = l3;
          i2 = i3;
          break label296;
        }
        if (localBufferInfo.size != 0) {}
        float f;
        for (boolean bool = true;; bool = false)
        {
          paramShortVideoCodec1.a().releaseOutputBuffer(i5, bool);
          l4 = l3;
          if (bool)
          {
            paramOutputSurface.d();
            paramOutputSurface.e();
            paramInputSurface.a(localBufferInfo.presentationTimeUs * 1000L);
            paramInputSurface.a();
            l4 = l3;
            if (l3 < 0L) {
              l4 = localBufferInfo.presentationTimeUs;
            }
            f = (float)(localBufferInfo.presentationTimeUs - l4) / (float)this.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a((int)(f * 10000.0F));
          }
          l5 = l4;
          i2 = i3;
          if ((localBufferInfo.flags & 0x4) == 0) {
            break;
          }
          i2 = 1;
          paramShortVideoCodec2.a().signalEndOfInputStream();
          l5 = l4;
          break;
        }
        localBufferInfo = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i3 = ((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int;
        if ((i3 == -1) || (i3 == -3)) {
          break label335;
        }
        if (i3 == -2)
        {
          if (n >= 0) {
            throw new IOException("video encoder changed its output format again?");
          }
          localMediaFormat1 = paramShortVideoCodec2.a().getOutputFormat();
          break label335;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          paramShortVideoCodec2.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
          break label335;
        }
        if (localBufferInfo.size != 0)
        {
          paramMediaMuxer.writeSampleData(n, ((AndroidCodec.BufferData)localObject).jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
          l1 = localBufferInfo.presentationTimeUs;
          f = (float)(localBufferInfo.presentationTimeUs - l5) / (float)this.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a((int)(f * 10000.0F));
        }
        if ((localBufferInfo.flags & 0x4) != 0) {
          i = 1;
        }
        paramShortVideoCodec2.a(((AndroidCodec.BufferData)localObject).jdField_a_of_type_Int);
        break label335;
        return;
        break label335;
        k = 0;
      }
      break label218;
      break label133;
      break label138;
      break label424;
      break label394;
    }
  }
  
  protected void a(File paramFile, VideoConverter.Processor paramProcessor)
  {
    Object localObject2 = paramFile.getAbsolutePath();
    Object localObject1 = a("video/avc");
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
      }
      throw new IOException("Unable to find an appropriate codec for video/avc");
    }
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject1).getName());
    }
    MediaExtractor localMediaExtractor1 = new MediaExtractor();
    localMediaExtractor1.setDataSource((String)localObject2);
    if (b(localMediaExtractor1) < 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    MediaExtractor localMediaExtractor2 = new MediaExtractor();
    localMediaExtractor2.setDataSource((String)localObject2);
    int i = a(localMediaExtractor2);
    if (i < 0) {
      throw new IOException("No video track found in " + paramFile);
    }
    localObject1 = localMediaExtractor2.getTrackFormat(i);
    paramFile = a((MediaFormat)localObject1, (String)localObject2);
    int n = (int)paramFile[2];
    int k = (int)paramFile[0];
    i = (int)paramFile[1];
    this.jdField_a_of_type_Long = paramFile[3];
    VideoConverter.VideoConvertConfig localVideoConvertConfig = paramProcessor.a(k, i);
    if ((localVideoConvertConfig.jdField_a_of_type_Long >= 0L) && (localVideoConvertConfig.jdField_b_of_type_Long > 0L) && (localVideoConvertConfig.jdField_b_of_type_Long - localVideoConvertConfig.jdField_a_of_type_Long > 1000L))
    {
      this.c = (localVideoConvertConfig.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_Long = (localVideoConvertConfig.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_Long = (this.c - this.jdField_b_of_type_Long);
      localMediaExtractor2.seekTo(this.jdField_b_of_type_Long, 2);
      localMediaExtractor1.seekTo(this.jdField_b_of_type_Long, 2);
    }
    int j;
    int m;
    if (!localVideoConvertConfig.jdField_a_of_type_Boolean)
    {
      j = k;
      m = i;
      if (n != 90)
      {
        if (n == 270)
        {
          m = i;
          j = k;
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label626;
        }
        paramProcessor = MediaFormat.createVideoFormat("video/avc", Math.round(m * localVideoConvertConfig.jdField_a_of_type_Float / 16.0F) * 16, Math.round(j * localVideoConvertConfig.jdField_a_of_type_Float / 16.0F) * 16);
        paramProcessor.setInteger("color-format", 2130708361);
        paramProcessor.setInteger("bitrate", localVideoConvertConfig.jdField_a_of_type_Int);
        paramProcessor.setFloat("frame-rate", localVideoConvertConfig.jdField_b_of_type_Int);
        paramProcessor.setInteger("i-frame-interval", 1);
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + paramProcessor);
        }
        paramFile = new AtomicReference();
        localObject2 = a(paramProcessor, paramFile);
        paramProcessor = new InputSurface((Surface)paramFile.get());
        paramProcessor.c();
        paramFile = new OutputSurface();
        localObject1 = a((MediaFormat)localObject1, paramFile.a);
      }
    }
    for (;;)
    {
      MediaMuxer localMediaMuxer = new MediaMuxer(localVideoConvertConfig.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 0);
      if ((this.jdField_b_of_type_Boolean) && (localVideoConvertConfig.jdField_a_of_type_Boolean)) {
        localMediaMuxer.setOrientationHint(n);
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = ((ShortVideoCodec)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec = ((ShortVideoCodec)localObject2);
      this.jdField_a_of_type_AndroidMediaMediaMuxer = localMediaMuxer;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface = paramProcessor;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface = paramFile;
      return;
      j = i;
      m = k;
      break;
      label626:
      paramFile = null;
      paramProcessor = null;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  long[] a(MediaFormat paramMediaFormat, String paramString)
  {
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    paramMediaFormat = new MediaMetadataRetriever();
    paramMediaFormat.setDataSource(paramString);
    paramString = paramMediaFormat.extractMetadata(24);
    if (paramString == null) {}
    for (int i = 0;; i = Integer.parseInt(paramString))
    {
      paramMediaFormat.release();
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramString);
      }
      return new long[] { j, k, i, l };
    }
  }
  
  int b(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("audio/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(0);
        a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor);
        a(this.jdField_a_of_type_AndroidMediaMediaExtractor, this.jdField_b_of_type_AndroidMediaMediaExtractor, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec, this.jdField_b_of_type_ComTencentMobileqqShortvideoMediacodecShortVideoCodec, this.jdField_a_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterOutputSurface);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(10000);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a();
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JBMR2VideoConverterImpl", 1, localException2.getMessage(), localException2);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException2);
        try
        {
          a();
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
        QLog.d("JBMR2VideoConverterImpl", 2, localException3.getMessage(), localException3);
        return;
      }
      finally {}
      try
      {
        a();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException1);
        if (QLog.isColorLevel())
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException1.getMessage(), localException1);
          return;
        }
      }
    }
    try
    {
      a();
      throw ((Throwable)localObject);
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        localException4.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter$Processor.a(localException4);
        if (QLog.isColorLevel())
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException4.getMessage(), localException4);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */