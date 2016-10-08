import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwCodec;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwDataSource;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwThumbGen;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwVideoFpsSmooth;
import com.tencent.mobileqq.shortvideo.util.SVMp4Merge;
import com.tencent.mobileqq.shortvideo.util.videoconverter.InputSurface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class uqo
  implements SVHwDataSource, SVHwOutputNotify, Runnable
{
  private int jdField_a_of_type_Int;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private SVHwCodec jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
  private SVHwDataSource jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource;
  private SVHwOutputNotify jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify;
  SVHwThumbGen jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen;
  private SVHwVideoFpsSmooth jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth;
  private InputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterInputSurface;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private uqq jdField_a_of_type_Uqq;
  uqr jdField_a_of_type_Uqr;
  private uqs jdField_a_of_type_Uqs;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private SVHwCodec jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private MediaFormat jdField_d_of_type_AndroidMediaMediaFormat;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private volatile boolean jdField_n_of_type_Boolean;
  private boolean o;
  private volatile boolean p;
  
  public uqo(SVHwEncoder paramSVHwEncoder, String paramString, SVHwOutputNotify paramSVHwOutputNotify, SVHwDataSource paramSVHwDataSource, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec = new SVHwCodec();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec = new SVHwCodec();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth = new SVHwVideoFpsSmooth();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Uqs = new uqs(this);
    this.jdField_a_of_type_Uqq = new uqq(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen = new SVHwThumbGen();
    this.jdField_a_of_type_Uqr = new uqr(this);
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_e_of_type_JavaLangString = a(paramString);
    this.jdField_g_of_type_Boolean = paramBoolean;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify = paramSVHwOutputNotify;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource = paramSVHwDataSource;
    a();
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_n_of_type_Int = paramInt;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.o = false;
    this.jdField_g_of_type_Int = 0;
  }
  
  float a(int paramInt)
  {
    int i1 = SVHwEncoder.h(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    int i2 = SVHwEncoder.i(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    int i3 = SVHwEncoder.j(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    return paramInt * 1000.0F / (i1 * i2 * i3);
  }
  
  int a()
  {
    this.jdField_a_of_type_Uqq.a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_c_of_type_AndroidMediaMediaFormat, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Uqq.c = this.jdField_a_of_type_Uqq.a();
    if (!bool) {
      return -2;
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    int i4 = 2;
    Object localObject3 = SVHwCodec.a("audio/mp4a-latm");
    Object localObject2 = SVHwCodec.b("audio/mp4a-latm", true);
    if ((((List)localObject3).size() <= 0) && (((List)localObject2).size() <= 0)) {
      return -7;
    }
    int i1;
    String str;
    if (((List)localObject2).size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("audioEncodeInit", " HardCodecSize=" + ((List)localObject2).size());
      i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((List)localObject2, "audio/mp4a-latm");
      if (i1 < 0)
      {
        str = ((MediaCodecInfo)((List)localObject2).get(((List)localObject2).size() - 1)).getName();
        localObject2 = ((MediaCodecInfo)((List)localObject2).get(0)).getCapabilitiesForType("audio/mp4a-latm");
        if ((((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels == null) || (((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length <= 0)) {
          break label443;
        }
        i1 = localObject2.profileLevels[0].profile;
      }
    }
    for (;;)
    {
      int i2;
      if (((List)localObject3).size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("audioEncodeInit", " softCodecSize=" + ((List)localObject3).size());
        i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((List)localObject3, "audio/mp4a-latm");
        if (i2 < 0)
        {
          localObject2 = ((MediaCodecInfo)((List)localObject3).get(0)).getName();
          localObject3 = ((MediaCodecInfo)((List)localObject3).get(0)).getCapabilitiesForType("audio/mp4a-latm");
          localObject1 = localObject2;
          if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels == null) {
            break label437;
          }
          localObject1 = localObject2;
          if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels.length <= 0) {
            break label437;
          }
          i2 = localObject3.profileLevels[0].profile;
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        label314:
        int i3 = i1;
        if (i1 == -1) {
          i3 = 2;
        }
        if (i2 == -1) {}
        for (i1 = i4;; i1 = i2)
        {
          this.jdField_d_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
          this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("bitrate", paramInt3);
          this.jdField_b_of_type_JavaLangString = str;
          this.jdField_c_of_type_JavaLangString = ((String)localObject1);
          this.jdField_d_of_type_Int = i3;
          this.jdField_e_of_type_Int = i1;
          return 0;
          str = ((MediaCodecInfo)((List)localObject2).get(i1)).getName();
          i1 = 2;
          break;
          localObject1 = ((MediaCodecInfo)((List)localObject3).get(i2)).getName();
          i2 = 2;
          break label314;
        }
        label437:
        i2 = -1;
      }
      label443:
      i1 = -1;
      continue;
      i1 = -1;
      str = null;
    }
  }
  
  int a(MediaFormat paramMediaFormat, String paramString, int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i5 = -1;
    List localList = SVHwCodec.b(paramString, true);
    if (localList.size() <= 0) {
      return -6;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("encodeVideoInit", " codecname=" + ((MediaCodecInfo)localList.get(i1)).getName());
      i1 += 1;
    }
    int i2 = 0;
    int i3 = i5;
    i1 = i4;
    if (i2 < localList.size())
    {
      int[] arrayOfInt = SVHwCodec.a((MediaCodecInfo)localList.get(i2), paramString).colorFormats;
      i1 = 0;
      while (i1 < arrayOfInt.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("encodeVideoInit", " colorformat=0x" + Integer.toHexString(arrayOfInt[i1]));
        i1 += 1;
      }
      if (ArrayUtils.a(arrayOfInt, 21))
      {
        i1 = 21;
        i3 = i2;
      }
    }
    else
    {
      if (i3 >= 0) {
        break label395;
      }
      i2 = 0;
      label221:
      if (i2 >= localList.size()) {
        break label395;
      }
      if (!ArrayUtils.a(SVHwCodec.a((MediaCodecInfo)localList.get(i2), paramString).colorFormats, 19)) {
        break label289;
      }
      i1 = 19;
    }
    for (;;)
    {
      if ((i1 != 19) && (i1 != 21))
      {
        return -1;
        i2 += 1;
        break;
        label289:
        i2 += 1;
        break label221;
      }
      if ((i1 == 2130708361) || (i1 == 19)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.G = 19;
      }
      for (;;)
      {
        paramMediaFormat.setInteger("color-format", i1);
        paramMediaFormat.setInteger("frame-rate", paramInt1);
        paramMediaFormat.setInteger("bitrate", paramInt2);
        paramMediaFormat.setInteger("i-frame-interval", 1);
        this.jdField_a_of_type_JavaLangString = ((MediaCodecInfo)localList.get(i2)).getName();
        return 0;
        if (i1 == 21) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.G = 21;
        }
      }
      label395:
      i2 = i3;
    }
  }
  
  int a(boolean paramBoolean)
  {
    int i1 = 0;
    this.jdField_a_of_type_Uqq.a();
    try
    {
      bool = a(paramBoolean).a();
      if (paramBoolean)
      {
        this.jdField_a_of_type_Uqq.d = this.jdField_a_of_type_Uqq.a();
        if (!bool) {
          i1 = -3;
        }
        return i1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(SVHwEncoder.a(), 2, "Exception", localException);
        }
        boolean bool = false;
        continue;
        this.jdField_a_of_type_Uqq.i = this.jdField_a_of_type_Uqq.a();
      }
    }
  }
  
  long a()
  {
    long l1;
    if (SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder)) {
      l1 = this.jdField_n_of_type_Int;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.jdField_a_of_type_Uqq.b();
      l1 = l2;
    } while (l2 <= this.jdField_n_of_type_Int);
    return this.jdField_n_of_type_Int;
  }
  
  SVHwCodec a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
    }
    return this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec;
  }
  
  public SVHwEncoder.HwFrame a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource.a();
  }
  
  public SVHwEncoder.HwFrame a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource.a(paramInt);
  }
  
  String a()
  {
    return this.jdField_e_of_type_JavaLangString + "shortvideo_merge" + ".mp4";
  }
  
  String a(String paramString)
  {
    paramString = paramString + "_qq_hw/";
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  void a()
  {
    this.jdField_f_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "shortvideo_seg_" + this.jdField_f_of_type_Int + ".mp4");
    this.jdField_f_of_type_Int += 1;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder) + " mVideoWritedFrameCount=" + this.jdField_h_of_type_Int + " mVideoEncodedframeCount=" + this.jdField_i_of_type_Int + " mVideoMuxeredframeCount=" + this.jdField_j_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder) + " mAudioWritedFrameCount=" + this.jdField_k_of_type_Int + " mAudioEncodedframeCount=" + this.jdField_l_of_type_Int + " mAudioMuxeredframeCount=" + this.jdField_m_of_type_Int);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svSegmentOK:path=" + paramString + " index=" + paramInt1 + "width=" + paramInt2 + " height=" + paramInt3 + " mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString1, paramInt1, paramInt2, paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svThumbOK:path=" + paramString1 + " md5=" + paramString2 + "width=" + paramInt1 + " height=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.a(paramString, paramInt, paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svMergeOK:path=" + paramString + " totalTime=" + paramInt + " mergeTime=" + paramLong + " mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  void a(List paramList, MediaFormat paramMediaFormat, int paramInt, String paramString)
  {
    paramList = SVHwCodec.a((MediaCodecInfo)paramList.get(paramInt), paramString);
    paramInt = 16;
    int i2 = 0;
    if (i2 < paramList.profileLevels.length)
    {
      switch (paramList.profileLevels[i2].profile)
      {
      }
      for (;;)
      {
        i2 += 1;
        break;
        paramMediaFormat.setInteger("profile", 1);
        int i1 = paramInt;
        if (paramInt < paramList.profileLevels[i2].level) {
          i1 = paramList.profileLevels[i2].level;
        }
        paramMediaFormat.setInteger("level", i1);
        paramInt = i1;
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    try
    {
      SVHwCodec localSVHwCodec = a(paramBoolean);
      this.jdField_a_of_type_Uqq.a();
      localSVHwCodec.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Uqq.d = this.jdField_a_of_type_Uqq.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_Uqq.a();
        localSVHwCodec.d();
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_Uqq.f = this.jdField_a_of_type_Uqq.a();
        return;
        this.jdField_a_of_type_Uqq.i = this.jdField_a_of_type_Uqq.a();
      }
      this.jdField_a_of_type_Uqq.k = this.jdField_a_of_type_Uqq.a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
  }
  
  boolean a(String paramString)
  {
    if (SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))
    {
      a(paramString);
      return true;
    }
    if (SVHwEncoder.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
      int i2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
      if ((i1 <= 0) && (i2 <= 0))
      {
        a(paramString + "videosize=" + i1 + " audiosize=" + i2);
        return true;
      }
    }
    return false;
  }
  
  boolean a(ArrayList paramArrayList)
  {
    boolean bool2 = false;
    for (;;)
    {
      SVHwEncoder.HwFrame localHwFrame = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(paramArrayList);
      bool1 = bool2;
      if (localHwFrame == null) {
        return bool1;
      }
      if (!localHwFrame.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(paramArrayList);
    }
    boolean bool1 = true;
    return bool1;
  }
  
  /* Error */
  boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   9: ldc_w 466
    //   12: new 192	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 468
    //   22: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   29: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: ldc_w 471
    //   35: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_1
    //   39: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: ldc_w 473
    //   45: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   58: ifeq +99 -> 157
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   66: aload_0
    //   67: iconst_m1
    //   68: putfield 63	uqo:jdField_b_of_type_Int	I
    //   71: aload_0
    //   72: iconst_m1
    //   73: putfield 65	uqo:jdField_c_of_type_Int	I
    //   76: iload_1
    //   77: ifeq +89 -> 166
    //   80: aload_0
    //   81: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   84: invokevirtual 480	android/media/MediaMuxer:stop	()V
    //   87: aload_0
    //   88: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   91: ldc_w 466
    //   94: new 192	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 468
    //   104: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   111: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: ldc_w 471
    //   117: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   124: ldc_w 482
    //   127: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: iload_1
    //   137: ifeq +49 -> 186
    //   140: aload_0
    //   141: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   144: invokevirtual 485	android/media/MediaMuxer:release	()V
    //   147: iload 4
    //   149: istore_1
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   155: iload_1
    //   156: istore_3
    //   157: iload_3
    //   158: ireturn
    //   159: astore_2
    //   160: aload_2
    //   161: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   164: iconst_1
    //   165: ireturn
    //   166: aload_0
    //   167: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   170: invokevirtual 480	android/media/MediaMuxer:stop	()V
    //   173: goto -86 -> 87
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   181: iconst_1
    //   182: istore_1
    //   183: goto -33 -> 150
    //   186: aload_0
    //   187: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   190: invokevirtual 485	android/media/MediaMuxer:release	()V
    //   193: iload 4
    //   195: istore_1
    //   196: goto -46 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	uqo
    //   0	199	1	paramBoolean	boolean
    //   159	2	2	localIllegalStateException1	IllegalStateException
    //   176	2	2	localIllegalStateException2	IllegalStateException
    //   1	157	3	bool1	boolean
    //   3	191	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   80	87	159	java/lang/IllegalStateException
    //   140	147	176	java/lang/IllegalStateException
  }
  
  int b()
  {
    this.jdField_a_of_type_Uqq.a();
    if (this.jdField_c_of_type_JavaLangString != null) {
      this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_e_of_type_Int);
    }
    for (boolean bool1 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_c_of_type_JavaLangString);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(SVHwEncoder.a(), 2, "audioEncodeInit: sfCodecinit error codecNameHw=" + this.jdField_c_of_type_JavaLangString);
        }
        bool2 = bool1;
        if (this.jdField_b_of_type_JavaLangString != null)
        {
          this.jdField_d_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", this.jdField_d_of_type_Int);
          bool2 = this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.a(this.jdField_d_of_type_AndroidMediaMediaFormat, this.jdField_b_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_Uqq.h = this.jdField_a_of_type_Uqq.a();
      if (!bool2) {
        return -8;
      }
      return 0;
    }
  }
  
  long b()
  {
    long l1;
    if (SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder)) {
      l1 = this.jdField_n_of_type_Int;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.jdField_a_of_type_Uqq.c();
      l1 = l2;
    } while (l2 <= this.jdField_n_of_type_Int);
    return this.jdField_n_of_type_Int;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svEncodeBegin mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svEncodeProgress: progress=" + paramInt + " mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.b(paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svErrorOcured:error=" + paramInt1 + " subcode=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  int c()
  {
    String str = SVHwCodec.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Uqq.a();
    this.jdField_c_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat(str, SVHwEncoder.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    int i1 = a(this.jdField_c_of_type_AndroidMediaMediaFormat, str, (int)SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.k(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    this.jdField_a_of_type_Uqq.b = this.jdField_a_of_type_Uqq.a();
    if (i1 != 0) {}
    int i2;
    do
    {
      do
      {
        return i1;
      } while (!this.jdField_g_of_type_Boolean);
      this.jdField_a_of_type_Uqq.a();
      i2 = a(SVHwEncoder.h(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.i(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.l(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
      this.jdField_a_of_type_Uqq.g = this.jdField_a_of_type_Uqq.a();
      i1 = i2;
    } while (i2 == 0);
    return i2;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify != null) && (!SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder))) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_callback_msg", "svEncodeEnd mCacellVideoEncode=" + SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  int d()
  {
    i();
    int i1 = a();
    if (i1 != 0) {}
    int i2;
    do
    {
      do
      {
        do
        {
          return i1;
          j();
          i2 = a(true);
          i1 = i2;
        } while (i2 != 0);
        i1 = i2;
      } while (!this.jdField_g_of_type_Boolean);
      i2 = b();
      i1 = i2;
    } while (i2 != 0);
    return a(false);
  }
  
  void d()
  {
    if ((this.jdField_f_of_type_Int == 1) && (!SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder)) && (!this.jdField_m_of_type_Boolean) && (this.jdField_h_of_type_Int >= 1))
    {
      this.jdField_a_of_type_Uqq.a();
      this.jdField_n_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long = 0L;
      new uqp(this).execute(new Void[0]);
      this.jdField_m_of_type_Boolean = true;
      this.jdField_a_of_type_Uqq.m = this.jdField_a_of_type_Uqq.a();
    }
  }
  
  int e()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", (int)SVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("bitrate", SVHwEncoder.k(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    this.jdField_a_of_type_AndroidMediaMediaFormat = null;
    int i1 = a();
    if (i1 != 0) {}
    int i2;
    do
    {
      return i1;
      i2 = a(true);
      i1 = i2;
    } while (i2 == 0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("VideoEncodeExit", "err=" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.d();
    return i2;
  }
  
  void e()
  {
    this.jdField_a_of_type_Int = 0;
    if ((this.jdField_n_of_type_Boolean) && (!this.o))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_e_of_type_Int == 0) {
        break label163;
      }
      this.jdField_a_of_type_Int = -9;
      b(-9, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_e_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "genThumbFile mLastErrCode=" + this.jdField_a_of_type_Int + " subcode=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_e_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_video_segment_notify_msg", "svThumbOK:mCallSegmentIndex=" + this.jdField_g_of_type_Int + " mLastErrCode=" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Uqq.l = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long;
      this.o = true;
      return;
      label163:
      a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_b_of_type_JavaLangString, SVHwEncoder.f(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.g(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString);
    }
  }
  
  int f()
  {
    try
    {
      Thread.sleep(300L);
      this.jdField_b_of_type_AndroidMediaMediaFormat = null;
      int i1 = b();
      if (i1 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("audioEncodeInit", "err=" + this.jdField_a_of_type_Int);
      }
      int i2;
      do
      {
        return i1;
        i2 = a(false);
        i1 = i2;
      } while (i2 == 0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("audioEncodeInit", "err=" + this.jdField_a_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec.d();
      return i2;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("pauseThread", "resumeThread:mHavePaused=" + this.p);
      this.p = false;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("pauseThread", "pauseThread:mHavePaused=" + this.p);
      if (!this.p) {
        this.p = true;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject.wait();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  void h()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    String str = a();
    if (i1 <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "size <= 0");
      return;
    }
    long l1;
    File localFile1;
    File localFile2;
    if (i1 == 1)
    {
      l1 = System.nanoTime();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "renameTo.");
      localFile1 = new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      localFile2 = new File(str);
      if (SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder)) {
        if ((this.jdField_j_of_type_Int <= 0) && (this.jdField_m_of_type_Int <= 0))
        {
          i1 = -2;
          FileUtils.d(localFile1.getAbsolutePath());
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=" + this.jdField_j_of_type_Int + " mAudioMuxeredframeCount=" + this.jdField_m_of_type_Int);
          l1 = (System.nanoTime() - l1) / 1000L;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "merge mp4 Over error=" + i1);
      if (i1 != 0) {
        break label335;
      }
      a(str, SVHwEncoder.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), l1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "notify merge OK......");
      return;
      if (!localFile1.renameTo(localFile2))
      {
        i1 = -1;
        break;
        FileUtils.a(localFile1, localFile2);
      }
      i1 = 0;
      break;
      l1 = System.nanoTime();
      i1 = SVMp4Merge.a(this.jdField_a_of_type_JavaUtilArrayList, str);
      l1 = (System.nanoTime() - l1) / 1000L;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "merge:time=" + l1 + " us");
    }
    label335:
    b(-40, i1);
    FileUtils.a(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("hw_av_merge_segment", "merge error delete cache......");
  }
  
  void i()
  {
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("width", SVHwEncoder.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    this.jdField_c_of_type_AndroidMediaMediaFormat.setInteger("height", SVHwEncoder.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  void j() {}
  
  void k() {}
  
  void l()
  {
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: invokevirtual 673	uqo:c	()I
    //   5: putfield 57	uqo:jdField_a_of_type_Int	I
    //   8: aload_0
    //   9: getfield 57	uqo:jdField_a_of_type_Int	I
    //   12: ifeq +56 -> 68
    //   15: aload_0
    //   16: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   19: ldc_w 675
    //   22: new 192	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 677
    //   32: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 57	uqo:jdField_a_of_type_Int	I
    //   39: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 57	uqo:jdField_a_of_type_Int	I
    //   53: iconst_0
    //   54: invokevirtual 572	uqo:b	(II)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 163	uqo:jdField_c_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 246	uqo:jdField_d_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   67: return
    //   68: aload_0
    //   69: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   72: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   75: ifne +54 -> 129
    //   78: getstatic 680	com/tencent/mobileqq/shortvideo/mediadevice/Lock:jdField_a_of_type_Boolean	Z
    //   81: ifne +48 -> 129
    //   84: getstatic 681	com/tencent/mobileqq/shortvideo/mediadevice/Lock:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   87: astore_2
    //   88: aload_2
    //   89: monitorenter
    //   90: getstatic 680	com/tencent/mobileqq/shortvideo/mediadevice/Lock:jdField_a_of_type_Boolean	Z
    //   93: istore 11
    //   95: iload 11
    //   97: ifne +30 -> 127
    //   100: getstatic 681	com/tencent/mobileqq/shortvideo/mediadevice/Lock:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   103: ldc2_w 639
    //   106: invokevirtual 683	java/lang/Object:wait	(J)V
    //   109: aload_0
    //   110: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   113: invokestatic 361	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   116: ifeq -26 -> 90
    //   119: aload_2
    //   120: monitorexit
    //   121: return
    //   122: astore_3
    //   123: aload_2
    //   124: monitorexit
    //   125: aload_3
    //   126: athrow
    //   127: aload_2
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   133: ldc_w 685
    //   136: ldc_w 687
    //   139: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: invokevirtual 688	uqo:b	()V
    //   146: aload_0
    //   147: aload_0
    //   148: invokevirtual 690	uqo:d	()I
    //   151: putfield 57	uqo:jdField_a_of_type_Int	I
    //   154: aload_0
    //   155: getfield 57	uqo:jdField_a_of_type_Int	I
    //   158: ifeq +60 -> 218
    //   161: aload_0
    //   162: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   165: ldc_w 692
    //   168: new 192	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 677
    //   178: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_0
    //   182: getfield 57	uqo:jdField_a_of_type_Int	I
    //   185: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 57	uqo:jdField_a_of_type_Int	I
    //   199: iconst_0
    //   200: invokevirtual 572	uqo:b	(II)V
    //   203: aload_0
    //   204: iconst_1
    //   205: invokevirtual 694	uqo:a	(Z)V
    //   208: aload_0
    //   209: iconst_0
    //   210: invokevirtual 694	uqo:a	(Z)V
    //   213: aload_0
    //   214: invokevirtual 696	uqo:k	()V
    //   217: return
    //   218: aload_0
    //   219: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   222: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   225: ifeq +125 -> 350
    //   228: aload_0
    //   229: iconst_1
    //   230: putfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   233: aload_0
    //   234: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   237: aload_0
    //   238: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   241: invokestatic 700	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   244: sipush 1000
    //   247: imul
    //   248: aload_0
    //   249: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   252: invokestatic 644	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   255: idiv
    //   256: i2f
    //   257: invokestatic 703	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;F)F
    //   260: pop
    //   261: aload_0
    //   262: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   265: invokevirtual 704	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	()V
    //   268: aload_0
    //   269: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   272: aload_0
    //   273: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   276: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   279: invokevirtual 707	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	(F)V
    //   282: aload_0
    //   283: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   286: ldc_w 709
    //   289: new 192	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 711
    //   299: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   306: invokestatic 700	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   309: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: ldc_w 713
    //   315: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   322: invokestatic 644	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   325: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 715
    //   331: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   338: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   341: invokevirtual 718	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   344: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aconst_null
    //   351: astore_3
    //   352: aload_3
    //   353: astore_2
    //   354: aload_0
    //   355: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   358: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   361: ifne +27 -> 388
    //   364: aload_3
    //   365: astore_2
    //   366: aload_0
    //   367: getfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   370: ifne +18 -> 388
    //   373: aload_0
    //   374: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   377: aload_0
    //   378: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   381: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   384: invokevirtual 454	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame;
    //   387: astore_2
    //   388: aload_0
    //   389: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   392: ldc_w 722
    //   395: new 192	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 724
    //   405: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_0
    //   409: getfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   412: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: ldc_w 726
    //   418: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   425: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_0
    //   435: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   438: ldc_w 722
    //   441: new 192	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 731
    //   451: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   458: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 733
    //   464: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   471: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_2
    //   481: ifnonnull +20 -> 501
    //   484: aload_0
    //   485: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   488: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   491: ifeq +96 -> 587
    //   494: aload_0
    //   495: getfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   498: ifne +89 -> 587
    //   501: aload_0
    //   502: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   505: ifnull +10 -> 515
    //   508: aload_0
    //   509: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   512: ifeq +75 -> 587
    //   515: aload_0
    //   516: invokevirtual 734	uqo:a	()J
    //   519: lstore 7
    //   521: aload_0
    //   522: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   525: ldc_w 736
    //   528: new 192	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 738
    //   538: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: lload 7
    //   543: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   546: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload_0
    //   553: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   556: lload 7
    //   558: invokevirtual 741	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(J)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;
    //   561: astore_3
    //   562: aload_3
    //   563: ifnull +11 -> 574
    //   566: aload_3
    //   567: getfield 744	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   570: iconst_m1
    //   571: if_icmpne +811 -> 1382
    //   574: aload_0
    //   575: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   578: ldc_w 722
    //   581: ldc_w 746
    //   584: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aconst_null
    //   588: astore_3
    //   589: aload_3
    //   590: astore_2
    //   591: aload_0
    //   592: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   595: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   598: ifne +27 -> 625
    //   601: aload_3
    //   602: astore_2
    //   603: aload_0
    //   604: getfield 123	uqo:jdField_c_of_type_Boolean	Z
    //   607: ifne +18 -> 625
    //   610: aload_0
    //   611: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   614: aload_0
    //   615: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   618: invokestatic 446	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   621: invokevirtual 454	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame;
    //   624: astore_2
    //   625: aload_2
    //   626: ifnonnull +20 -> 646
    //   629: aload_0
    //   630: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   633: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   636: ifeq +96 -> 732
    //   639: aload_0
    //   640: getfield 123	uqo:jdField_c_of_type_Boolean	Z
    //   643: ifne +89 -> 732
    //   646: aload_0
    //   647: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   650: ifnull +10 -> 660
    //   653: aload_0
    //   654: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   657: ifeq +75 -> 732
    //   660: aload_0
    //   661: invokevirtual 747	uqo:b	()J
    //   664: lstore 7
    //   666: aload_0
    //   667: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   670: ldc_w 749
    //   673: new 192	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 751
    //   683: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: lload 7
    //   688: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload_0
    //   698: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   701: lload 7
    //   703: invokevirtual 741	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(J)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;
    //   706: astore_3
    //   707: aload_3
    //   708: ifnull +11 -> 719
    //   711: aload_3
    //   712: getfield 744	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   715: iconst_m1
    //   716: if_icmpne +1368 -> 2084
    //   719: aload_0
    //   720: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   723: ldc_w 753
    //   726: ldc_w 746
    //   729: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: aload_0
    //   733: getfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   736: ifeq +107 -> 843
    //   739: aload_0
    //   740: getfield 123	uqo:jdField_c_of_type_Boolean	Z
    //   743: ifeq +100 -> 843
    //   746: aload_0
    //   747: getfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   750: ifeq +93 -> 843
    //   753: aload_0
    //   754: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   757: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   760: ifne +83 -> 843
    //   763: aload_0
    //   764: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   767: ldc_w 755
    //   770: new 192	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 757
    //   780: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_0
    //   784: getfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   787: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: ldc_w 715
    //   793: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_0
    //   797: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   800: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   803: invokevirtual 718	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   806: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: aload_0
    //   813: iconst_0
    //   814: putfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   817: aload_0
    //   818: iconst_1
    //   819: putfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   822: aload_0
    //   823: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   826: invokevirtual 704	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	()V
    //   829: aload_0
    //   830: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   833: aload_0
    //   834: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   837: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   840: invokevirtual 707	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	(F)V
    //   843: aload_0
    //   844: getfield 84	uqo:jdField_l_of_type_Boolean	Z
    //   847: ifeq +88 -> 935
    //   850: aload_0
    //   851: getfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   854: ifne +81 -> 935
    //   857: aload_0
    //   858: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   861: ifnull +10 -> 871
    //   864: aload_0
    //   865: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   868: ifeq +67 -> 935
    //   871: aload_0
    //   872: invokevirtual 734	uqo:a	()J
    //   875: lstore 7
    //   877: aload_0
    //   878: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   881: ldc_w 761
    //   884: new 192	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 763
    //   894: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: lload 7
    //   899: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   902: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: aload_0
    //   909: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   912: lload 7
    //   914: invokevirtual 765	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:b	(J)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;
    //   917: astore_2
    //   918: aload_2
    //   919: ifnonnull +1875 -> 2794
    //   922: aload_0
    //   923: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   926: ldc_w 761
    //   929: ldc_w 767
    //   932: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   935: aload_0
    //   936: getfield 84	uqo:jdField_l_of_type_Boolean	Z
    //   939: ifeq +88 -> 1027
    //   942: aload_0
    //   943: getfield 125	uqo:jdField_e_of_type_Boolean	Z
    //   946: ifne +81 -> 1027
    //   949: aload_0
    //   950: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   953: ifnull +10 -> 963
    //   956: aload_0
    //   957: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   960: ifeq +67 -> 1027
    //   963: aload_0
    //   964: invokevirtual 747	uqo:b	()J
    //   967: lstore 7
    //   969: aload_0
    //   970: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   973: ldc_w 769
    //   976: new 192	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   983: ldc_w 771
    //   986: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: lload 7
    //   991: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   994: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: aload_0
    //   1001: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   1004: lload 7
    //   1006: invokevirtual 765	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:b	(J)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;
    //   1009: astore_2
    //   1010: aload_2
    //   1011: ifnonnull +2244 -> 3255
    //   1014: aload_0
    //   1015: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1018: ldc_w 769
    //   1021: ldc_w 767
    //   1024: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1027: aload_0
    //   1028: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1031: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1034: ifeq +45 -> 1079
    //   1037: aload_0
    //   1038: getfield 773	uqo:jdField_h_of_type_Boolean	Z
    //   1041: ifne +38 -> 1079
    //   1044: aload_0
    //   1045: getfield 372	uqo:jdField_i_of_type_Int	I
    //   1048: bipush 100
    //   1050: imul
    //   1051: aload_0
    //   1052: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1055: invokestatic 700	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   1058: idiv
    //   1059: istore 4
    //   1061: aload_0
    //   1062: iload 4
    //   1064: invokevirtual 774	uqo:b	(I)V
    //   1067: iload 4
    //   1069: bipush 100
    //   1071: if_icmplt +8 -> 1079
    //   1074: aload_0
    //   1075: iconst_1
    //   1076: putfield 773	uqo:jdField_h_of_type_Boolean	Z
    //   1079: aload_0
    //   1080: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1083: invokestatic 776	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:d	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1086: ifeq +7 -> 1093
    //   1089: aload_0
    //   1090: invokevirtual 778	uqo:g	()V
    //   1093: aload_0
    //   1094: invokevirtual 779	uqo:d	()V
    //   1097: aload_0
    //   1098: invokevirtual 781	uqo:e	()V
    //   1101: aload_0
    //   1102: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1105: ifeq +2525 -> 3630
    //   1108: aload_0
    //   1109: iconst_1
    //   1110: invokevirtual 694	uqo:a	(Z)V
    //   1113: aload_0
    //   1114: iconst_0
    //   1115: invokevirtual 694	uqo:a	(Z)V
    //   1118: aload_0
    //   1119: invokevirtual 696	uqo:k	()V
    //   1122: aload_0
    //   1123: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1126: ldc_w 783
    //   1129: new 192	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1136: ldc_w 785
    //   1139: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: aload_0
    //   1143: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   1146: invokevirtual 786	uqq:toString	()Ljava/lang/String;
    //   1149: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1158: aload_0
    //   1159: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1162: ldc_w 574
    //   1165: ldc_w 788
    //   1168: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1171: aload_0
    //   1172: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1175: ifeq +3861 -> 5036
    //   1178: aload_0
    //   1179: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1182: ldc_w 574
    //   1185: new 192	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 790
    //   1195: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload_0
    //   1199: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1202: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1211: aload_0
    //   1212: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1215: iconst_1
    //   1216: invokestatic 793	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;Z)Z
    //   1219: pop
    //   1220: aload_0
    //   1221: iconst_1
    //   1222: invokevirtual 795	uqo:a	(Z)Z
    //   1225: pop
    //   1226: aload_0
    //   1227: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1230: invokestatic 387	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1233: ifeq +3810 -> 5043
    //   1236: aload_0
    //   1237: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1240: ldc_w 574
    //   1243: new 192	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1250: ldc_w 797
    //   1253: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload_0
    //   1257: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1260: invokestatic 387	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1263: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1272: aload_0
    //   1273: getfield 115	uqo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1276: invokestatic 662	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   1279: aload_0
    //   1280: aconst_null
    //   1281: putfield 117	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwOutputNotify	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwOutputNotify;
    //   1284: aload_0
    //   1285: aconst_null
    //   1286: putfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   1289: aload_0
    //   1290: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1293: invokestatic 799	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   1296: invokevirtual 802	java/util/ArrayList:clear	()V
    //   1299: aload_0
    //   1300: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1303: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   1306: invokevirtual 802	java/util/ArrayList:clear	()V
    //   1309: aload_0
    //   1310: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1313: invokestatic 446	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   1316: invokevirtual 802	java/util/ArrayList:clear	()V
    //   1319: aload_0
    //   1320: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1323: aconst_null
    //   1324: invokestatic 805	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   1327: pop
    //   1328: aload_0
    //   1329: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1332: aconst_null
    //   1333: invokestatic 807	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   1336: pop
    //   1337: aload_0
    //   1338: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1341: aconst_null
    //   1342: invokestatic 809	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   1345: pop
    //   1346: aload_0
    //   1347: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   1350: invokevirtual 704	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	()V
    //   1353: aload_0
    //   1354: iconst_0
    //   1355: putfield 139	uqo:jdField_g_of_type_Int	I
    //   1358: return
    //   1359: astore_2
    //   1360: aload_2
    //   1361: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   1364: aload_0
    //   1365: bipush -19
    //   1367: putfield 57	uqo:jdField_a_of_type_Int	I
    //   1370: aload_0
    //   1371: aload_0
    //   1372: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1375: iconst_0
    //   1376: invokevirtual 572	uqo:b	(II)V
    //   1379: goto -271 -> 1108
    //   1382: aload_3
    //   1383: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   1386: ifnonnull +83 -> 1469
    //   1389: aload_0
    //   1390: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   1393: astore_2
    //   1394: aload_2
    //   1395: aload_2
    //   1396: getfield 813	uqr:jdField_a_of_type_Int	I
    //   1399: iconst_1
    //   1400: iadd
    //   1401: putfield 813	uqr:jdField_a_of_type_Int	I
    //   1404: aload_0
    //   1405: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1408: ldc_w 815
    //   1411: new 192	java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1418: ldc_w 817
    //   1421: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: aload_0
    //   1425: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   1428: getfield 813	uqr:jdField_a_of_type_Int	I
    //   1431: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1440: aload_0
    //   1441: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   1444: getfield 813	uqr:jdField_a_of_type_Int	I
    //   1447: iconst_3
    //   1448: if_icmplt -861 -> 587
    //   1451: aload_0
    //   1452: bipush -21
    //   1454: putfield 57	uqo:jdField_a_of_type_Int	I
    //   1457: aload_0
    //   1458: aload_0
    //   1459: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1462: iconst_0
    //   1463: invokevirtual 572	uqo:b	(II)V
    //   1466: goto -358 -> 1108
    //   1469: aload_0
    //   1470: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   1473: iconst_0
    //   1474: putfield 813	uqr:jdField_a_of_type_Int	I
    //   1477: aload_0
    //   1478: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1481: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1484: ifeq +3600 -> 5084
    //   1487: aload_0
    //   1488: getfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   1491: ifnull +3593 -> 5084
    //   1494: aload_0
    //   1495: aload_0
    //   1496: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1499: getfield 289	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:G	I
    //   1502: invokevirtual 818	uqo:a	(I)Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame;
    //   1505: astore_2
    //   1506: aload_2
    //   1507: getfield 458	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Boolean	Z
    //   1510: ifne +297 -> 1807
    //   1513: aload_3
    //   1514: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   1517: invokevirtual 823	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1520: pop
    //   1521: aload_3
    //   1522: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   1525: invokevirtual 826	java/nio/ByteBuffer:capacity	()I
    //   1528: istore 4
    //   1530: aload_2
    //   1531: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   1534: aload_2
    //   1535: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   1538: isub
    //   1539: istore 5
    //   1541: iload 4
    //   1543: iload 5
    //   1545: if_icmplt +221 -> 1766
    //   1548: aload_3
    //   1549: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   1552: aload_2
    //   1553: getfield 831	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_ArrayOfByte	[B
    //   1556: aload_2
    //   1557: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   1560: iload 5
    //   1562: invokevirtual 835	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1565: pop
    //   1566: aload_2
    //   1567: aload_2
    //   1568: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   1571: iload 5
    //   1573: iadd
    //   1574: putfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   1577: aload_2
    //   1578: getfield 836	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Long	J
    //   1581: ldc2_w 639
    //   1584: lmul
    //   1585: lstore 9
    //   1587: aload_0
    //   1588: getfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   1591: ifeq +3486 -> 5077
    //   1594: aload_0
    //   1595: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   1598: aload_2
    //   1599: getfield 836	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Long	J
    //   1602: invokevirtual 839	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	(J)J
    //   1605: lstore 7
    //   1607: aload_0
    //   1608: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1611: ldc_w 736
    //   1614: new 192	java/lang/StringBuilder
    //   1617: dup
    //   1618: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1621: ldc_w 841
    //   1624: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: lload 9
    //   1629: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1632: ldc_w 843
    //   1635: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: lload 7
    //   1640: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1643: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1646: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1649: aload_0
    //   1650: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   1653: aload_3
    //   1654: aload_2
    //   1655: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   1658: lload 7
    //   1660: iconst_0
    //   1661: invokevirtual 846	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;IJI)V
    //   1664: aload_0
    //   1665: aload_0
    //   1666: getfield 368	uqo:jdField_h_of_type_Int	I
    //   1669: iconst_1
    //   1670: iadd
    //   1671: putfield 368	uqo:jdField_h_of_type_Int	I
    //   1674: aload_0
    //   1675: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1678: ldc_w 722
    //   1681: new 192	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1688: ldc_w 848
    //   1691: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_0
    //   1695: getfield 368	uqo:jdField_h_of_type_Int	I
    //   1698: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1707: aload_0
    //   1708: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   1711: iconst_1
    //   1712: invokevirtual 849	uqq:a	(Z)V
    //   1715: aload_0
    //   1716: getfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   1719: ifnonnull -1132 -> 587
    //   1722: aload_2
    //   1723: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   1726: aload_2
    //   1727: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   1730: if_icmpne -1143 -> 587
    //   1733: aload_0
    //   1734: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1737: aload_0
    //   1738: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1741: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   1744: invokevirtual 461	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)V
    //   1747: aload_0
    //   1748: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1751: aload_2
    //   1752: invokevirtual 852	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame;)Z
    //   1755: ifne -1168 -> 587
    //   1758: aload_2
    //   1759: aconst_null
    //   1760: putfield 831	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_ArrayOfByte	[B
    //   1763: goto -1176 -> 587
    //   1766: aload_0
    //   1767: bipush -12
    //   1769: putfield 57	uqo:jdField_a_of_type_Int	I
    //   1772: aload_0
    //   1773: aload_0
    //   1774: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1777: iconst_0
    //   1778: invokevirtual 572	uqo:b	(II)V
    //   1781: goto -673 -> 1108
    //   1784: astore_2
    //   1785: aload_2
    //   1786: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   1789: aload_0
    //   1790: bipush -17
    //   1792: putfield 57	uqo:jdField_a_of_type_Int	I
    //   1795: aload_0
    //   1796: aload_0
    //   1797: getfield 57	uqo:jdField_a_of_type_Int	I
    //   1800: iconst_0
    //   1801: invokevirtual 572	uqo:b	(II)V
    //   1804: goto -696 -> 1108
    //   1807: aload_0
    //   1808: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   1811: aload_3
    //   1812: iconst_0
    //   1813: lconst_0
    //   1814: iconst_4
    //   1815: invokevirtual 846	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;IJI)V
    //   1818: aload_0
    //   1819: iconst_1
    //   1820: putfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   1823: aload_0
    //   1824: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1827: ldc_w 722
    //   1830: new 192	java/lang/StringBuilder
    //   1833: dup
    //   1834: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1837: ldc_w 854
    //   1840: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_2
    //   1844: getfield 857	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Float	F
    //   1847: invokevirtual 718	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1850: ldc_w 859
    //   1853: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: aload_2
    //   1857: getfield 860	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_c_of_type_Int	I
    //   1860: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1869: aload_2
    //   1870: getfield 857	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Float	F
    //   1873: fconst_0
    //   1874: fcmpl
    //   1875: ifle +94 -> 1969
    //   1878: aload_0
    //   1879: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1882: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   1885: ifne +84 -> 1969
    //   1888: aload_0
    //   1889: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1892: ldc_w 755
    //   1895: new 192	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1902: ldc_w 862
    //   1905: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: aload_0
    //   1909: getfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   1912: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1915: ldc_w 864
    //   1918: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: aload_0
    //   1922: getfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   1925: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1928: ldc_w 715
    //   1931: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: aload_0
    //   1935: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1938: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   1941: invokevirtual 718	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1944: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1947: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1950: aload_0
    //   1951: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1954: aload_2
    //   1955: getfield 857	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Float	F
    //   1958: invokestatic 703	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;F)F
    //   1961: pop
    //   1962: aload_0
    //   1963: getfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   1966: ifeq +25 -> 1991
    //   1969: aload_2
    //   1970: getfield 860	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_c_of_type_Int	I
    //   1973: ifle -258 -> 1715
    //   1976: aload_0
    //   1977: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   1980: aload_2
    //   1981: getfield 860	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_c_of_type_Int	I
    //   1984: invokestatic 867	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;I)I
    //   1987: pop
    //   1988: goto -273 -> 1715
    //   1991: aload_0
    //   1992: iconst_1
    //   1993: putfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   1996: aload_0
    //   1997: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2000: ldc_w 755
    //   2003: new 192	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2010: ldc_w 862
    //   2013: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: aload_0
    //   2017: getfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   2020: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2023: ldc_w 864
    //   2026: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: aload_0
    //   2030: getfield 129	uqo:jdField_j_of_type_Boolean	Z
    //   2033: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2036: ldc_w 715
    //   2039: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2042: aload_0
    //   2043: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2046: invokestatic 524	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)F
    //   2049: invokevirtual 718	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   2052: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2055: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2058: goto -89 -> 1969
    //   2061: astore_2
    //   2062: aload_2
    //   2063: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   2066: aload_0
    //   2067: bipush -18
    //   2069: putfield 57	uqo:jdField_a_of_type_Int	I
    //   2072: aload_0
    //   2073: aload_0
    //   2074: getfield 57	uqo:jdField_a_of_type_Int	I
    //   2077: iconst_0
    //   2078: invokevirtual 572	uqo:b	(II)V
    //   2081: goto -973 -> 1108
    //   2084: aload_3
    //   2085: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2088: ifnonnull +83 -> 2171
    //   2091: aload_0
    //   2092: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   2095: astore_2
    //   2096: aload_2
    //   2097: aload_2
    //   2098: getfield 868	uqr:jdField_b_of_type_Int	I
    //   2101: iconst_1
    //   2102: iadd
    //   2103: putfield 868	uqr:jdField_b_of_type_Int	I
    //   2106: aload_0
    //   2107: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2110: ldc_w 815
    //   2113: new 192	java/lang/StringBuilder
    //   2116: dup
    //   2117: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2120: ldc_w 870
    //   2123: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: aload_0
    //   2127: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   2130: getfield 868	uqr:jdField_b_of_type_Int	I
    //   2133: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2142: aload_0
    //   2143: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   2146: getfield 868	uqr:jdField_b_of_type_Int	I
    //   2149: iconst_3
    //   2150: if_icmplt -1418 -> 732
    //   2153: aload_0
    //   2154: bipush -20
    //   2156: putfield 57	uqo:jdField_a_of_type_Int	I
    //   2159: aload_0
    //   2160: aload_0
    //   2161: getfield 57	uqo:jdField_a_of_type_Int	I
    //   2164: iconst_0
    //   2165: invokevirtual 572	uqo:b	(II)V
    //   2168: goto -1060 -> 1108
    //   2171: aload_0
    //   2172: getfield 108	uqo:jdField_a_of_type_Uqr	Luqr;
    //   2175: iconst_0
    //   2176: putfield 868	uqr:jdField_b_of_type_Int	I
    //   2179: aload_0
    //   2180: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2183: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   2186: ifeq +2888 -> 5074
    //   2189: aload_0
    //   2190: getfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   2193: ifnull +2881 -> 5074
    //   2196: aload_0
    //   2197: invokevirtual 871	uqo:a	()Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame;
    //   2200: astore_2
    //   2201: aload_2
    //   2202: getfield 458	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Boolean	Z
    //   2205: ifne +508 -> 2713
    //   2208: aload_3
    //   2209: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2212: invokevirtual 823	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2215: pop
    //   2216: aload_3
    //   2217: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2220: invokevirtual 826	java/nio/ByteBuffer:capacity	()I
    //   2223: istore 5
    //   2225: aload_2
    //   2226: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   2229: aload_2
    //   2230: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2233: isub
    //   2234: istore 6
    //   2236: iload 5
    //   2238: iload 6
    //   2240: if_icmplt +315 -> 2555
    //   2243: aload_3
    //   2244: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2247: aload_2
    //   2248: getfield 831	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_ArrayOfByte	[B
    //   2251: aload_2
    //   2252: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2255: iload 6
    //   2257: invokevirtual 835	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2260: pop
    //   2261: aload_2
    //   2262: aload_2
    //   2263: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2266: iload 6
    //   2268: iadd
    //   2269: putfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2272: iload 6
    //   2274: istore 4
    //   2276: aload_0
    //   2277: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2280: ldc_w 753
    //   2283: new 192	java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2290: ldc_w 873
    //   2293: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: aload_2
    //   2297: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2300: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2303: ldc_w 875
    //   2306: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: aload_2
    //   2310: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   2313: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2316: ldc_w 877
    //   2319: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2322: iload 6
    //   2324: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2327: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2330: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2333: aload_0
    //   2334: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2337: ldc_w 753
    //   2340: new 192	java/lang/StringBuilder
    //   2343: dup
    //   2344: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2347: ldc_w 879
    //   2350: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2353: iload 5
    //   2355: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2358: ldc_w 881
    //   2361: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2364: iload 4
    //   2366: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2369: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2372: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2375: ldc2_w 639
    //   2378: aload_2
    //   2379: getfield 836	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Long	J
    //   2382: lmul
    //   2383: lstore 9
    //   2385: aload_0
    //   2386: getfield 698	uqo:jdField_i_of_type_Boolean	Z
    //   2389: ifeq +2678 -> 5067
    //   2392: aload_0
    //   2393: iload 4
    //   2395: invokevirtual 883	uqo:a	(I)F
    //   2398: fstore_1
    //   2399: aload_0
    //   2400: getfield 77	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwVideoFpsSmooth	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth;
    //   2403: fload_1
    //   2404: invokevirtual 886	com/tencent/mobileqq/shortvideo/hwcodec/SVHwVideoFpsSmooth:a	(F)J
    //   2407: lstore 7
    //   2409: aload_0
    //   2410: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2413: ldc_w 749
    //   2416: new 192	java/lang/StringBuilder
    //   2419: dup
    //   2420: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2423: ldc_w 841
    //   2426: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: lload 9
    //   2431: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2434: ldc_w 843
    //   2437: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: lload 7
    //   2442: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2445: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2448: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2451: aload_0
    //   2452: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   2455: aload_3
    //   2456: iload 4
    //   2458: lload 7
    //   2460: iconst_0
    //   2461: invokevirtual 846	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;IJI)V
    //   2464: aload_0
    //   2465: aload_0
    //   2466: getfield 378	uqo:jdField_k_of_type_Int	I
    //   2469: iconst_1
    //   2470: iadd
    //   2471: putfield 378	uqo:jdField_k_of_type_Int	I
    //   2474: aload_0
    //   2475: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2478: ldc_w 753
    //   2481: new 192	java/lang/StringBuilder
    //   2484: dup
    //   2485: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2488: ldc_w 888
    //   2491: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: aload_0
    //   2495: getfield 378	uqo:jdField_k_of_type_Int	I
    //   2498: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2501: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2504: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2507: aload_0
    //   2508: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   2511: iconst_0
    //   2512: invokevirtual 849	uqq:a	(Z)V
    //   2515: aload_0
    //   2516: getfield 119	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwDataSource	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwDataSource;
    //   2519: ifnonnull -1787 -> 732
    //   2522: aload_2
    //   2523: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2526: aload_2
    //   2527: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   2530: if_icmpne -1798 -> 732
    //   2533: aload_0
    //   2534: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2537: aload_0
    //   2538: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2541: invokestatic 446	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   2544: invokevirtual 461	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)V
    //   2547: aload_2
    //   2548: aconst_null
    //   2549: putfield 831	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_ArrayOfByte	[B
    //   2552: goto -1820 -> 732
    //   2555: aload_3
    //   2556: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2559: aload_2
    //   2560: getfield 831	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_ArrayOfByte	[B
    //   2563: aload_2
    //   2564: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2567: iload 5
    //   2569: invokevirtual 835	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2572: pop
    //   2573: aload_2
    //   2574: aload_2
    //   2575: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2578: iload 5
    //   2580: iadd
    //   2581: putfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2584: iload 5
    //   2586: istore 4
    //   2588: goto -312 -> 2276
    //   2591: astore_3
    //   2592: aload_0
    //   2593: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2596: ldc_w 749
    //   2599: new 192	java/lang/StringBuilder
    //   2602: dup
    //   2603: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2606: ldc_w 873
    //   2609: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: aload_2
    //   2613: getfield 828	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_a_of_type_Int	I
    //   2616: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2619: ldc_w 875
    //   2622: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: aload_2
    //   2626: getfield 827	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwFrame:jdField_b_of_type_Int	I
    //   2629: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2632: ldc_w 877
    //   2635: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: iload 6
    //   2640: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2643: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2646: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2649: aload_0
    //   2650: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2653: ldc_w 749
    //   2656: new 192	java/lang/StringBuilder
    //   2659: dup
    //   2660: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2663: ldc_w 879
    //   2666: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: iload 5
    //   2671: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2674: ldc_w 881
    //   2677: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: iload 4
    //   2682: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2685: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2688: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2691: aload_3
    //   2692: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   2695: aload_0
    //   2696: bipush -16
    //   2698: putfield 57	uqo:jdField_a_of_type_Int	I
    //   2701: aload_0
    //   2702: aload_0
    //   2703: getfield 57	uqo:jdField_a_of_type_Int	I
    //   2706: iconst_0
    //   2707: invokevirtual 572	uqo:b	(II)V
    //   2710: goto -1602 -> 1108
    //   2713: aload_0
    //   2714: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   2717: aload_3
    //   2718: iconst_0
    //   2719: lconst_0
    //   2720: iconst_4
    //   2721: invokevirtual 846	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;IJI)V
    //   2724: aload_0
    //   2725: iconst_1
    //   2726: putfield 123	uqo:jdField_c_of_type_Boolean	Z
    //   2729: aload_0
    //   2730: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2733: ldc_w 753
    //   2736: new 192	java/lang/StringBuilder
    //   2739: dup
    //   2740: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2743: ldc_w 888
    //   2746: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: aload_0
    //   2750: getfield 378	uqo:jdField_k_of_type_Int	I
    //   2753: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2756: ldc_w 890
    //   2759: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2765: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2768: goto -253 -> 2515
    //   2771: astore_2
    //   2772: aload_2
    //   2773: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   2776: aload_0
    //   2777: bipush -23
    //   2779: putfield 57	uqo:jdField_a_of_type_Int	I
    //   2782: aload_0
    //   2783: aload_0
    //   2784: getfield 57	uqo:jdField_a_of_type_Int	I
    //   2787: iconst_0
    //   2788: invokevirtual 572	uqo:b	(II)V
    //   2791: goto -1683 -> 1108
    //   2794: aload_2
    //   2795: getfield 893	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   2798: astore_3
    //   2799: aload_2
    //   2800: getfield 744	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   2803: istore 4
    //   2805: iload 4
    //   2807: iconst_m1
    //   2808: if_icmpne +19 -> 2827
    //   2811: aload_0
    //   2812: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2815: ldc_w 761
    //   2818: ldc_w 895
    //   2821: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2824: goto -1889 -> 935
    //   2827: iload 4
    //   2829: bipush -3
    //   2831: if_icmpne +19 -> 2850
    //   2834: aload_0
    //   2835: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2838: ldc_w 761
    //   2841: ldc_w 897
    //   2844: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2847: goto -1912 -> 935
    //   2850: iload 4
    //   2852: bipush -2
    //   2854: if_icmpne +44 -> 2898
    //   2857: aload_0
    //   2858: aload_0
    //   2859: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   2862: invokevirtual 900	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	()Landroid/media/MediaCodec;
    //   2865: invokevirtual 906	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   2868: putfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   2871: aload_0
    //   2872: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   2875: aload_0
    //   2876: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   2879: invokevirtual 909	uqs:a	(Landroid/media/MediaFormat;)V
    //   2882: aload_0
    //   2883: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2886: ldc_w 761
    //   2889: ldc_w 911
    //   2892: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2895: goto -1960 -> 935
    //   2898: aload_3
    //   2899: getfield 916	android/media/MediaCodec$BufferInfo:flags	I
    //   2902: iconst_2
    //   2903: iand
    //   2904: ifeq +44 -> 2948
    //   2907: aload_0
    //   2908: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2911: ldc_w 761
    //   2914: ldc_w 918
    //   2917: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2920: aload_0
    //   2921: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2924: aload_2
    //   2925: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   2928: aload_3
    //   2929: ldc_w 920
    //   2932: bipush 30
    //   2934: invokevirtual 923	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;Ljava/lang/String;I)V
    //   2937: aload_0
    //   2938: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   2941: aload_2
    //   2942: invokevirtual 926	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;)V
    //   2945: goto -2010 -> 935
    //   2948: aload_0
    //   2949: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   2952: ldc_w 761
    //   2955: new 192	java/lang/StringBuilder
    //   2958: dup
    //   2959: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   2962: ldc_w 928
    //   2965: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2968: aload_3
    //   2969: getfield 930	android/media/MediaCodec$BufferInfo:size	I
    //   2972: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2975: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2978: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2981: aload_3
    //   2982: getfield 930	android/media/MediaCodec$BufferInfo:size	I
    //   2985: ifeq +182 -> 3167
    //   2988: aload_0
    //   2989: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   2992: iconst_1
    //   2993: invokevirtual 932	uqq:b	(Z)V
    //   2996: aload_0
    //   2997: aload_0
    //   2998: getfield 372	uqo:jdField_i_of_type_Int	I
    //   3001: iconst_1
    //   3002: iadd
    //   3003: putfield 372	uqo:jdField_i_of_type_Int	I
    //   3006: aload_0
    //   3007: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   3010: ifnull +206 -> 3216
    //   3013: aload_3
    //   3014: getfield 916	android/media/MediaCodec$BufferInfo:flags	I
    //   3017: iconst_1
    //   3018: iand
    //   3019: ifeq +26 -> 3045
    //   3022: aload_0
    //   3023: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3026: iconst_1
    //   3027: putfield 933	uqs:jdField_a_of_type_Boolean	Z
    //   3030: aload_0
    //   3031: getfield 143	uqo:jdField_j_of_type_Int	I
    //   3034: ifne +11 -> 3045
    //   3037: aload_0
    //   3038: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3041: iconst_1
    //   3042: putfield 934	uqs:jdField_c_of_type_Boolean	Z
    //   3045: aload_0
    //   3046: getfield 143	uqo:jdField_j_of_type_Int	I
    //   3049: ifne +18 -> 3067
    //   3052: aload_0
    //   3053: getfield 148	uqo:jdField_m_of_type_Int	I
    //   3056: ifne +149 -> 3205
    //   3059: aload_0
    //   3060: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3063: iconst_1
    //   3064: putfield 935	uqs:jdField_b_of_type_Boolean	Z
    //   3067: aload_0
    //   3068: aload_0
    //   3069: getfield 143	uqo:jdField_j_of_type_Int	I
    //   3072: iconst_1
    //   3073: iadd
    //   3074: putfield 143	uqo:jdField_j_of_type_Int	I
    //   3077: aload_0
    //   3078: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3081: ldc_w 937
    //   3084: new 192	java/lang/StringBuilder
    //   3087: dup
    //   3088: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3091: ldc_w 939
    //   3094: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: aload_0
    //   3098: getfield 63	uqo:jdField_b_of_type_Int	I
    //   3101: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3104: ldc_w 941
    //   3107: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: aload_3
    //   3111: getfield 944	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3114: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3117: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3120: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3123: aload_0
    //   3124: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3127: aload_3
    //   3128: getfield 944	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3131: iconst_1
    //   3132: invokevirtual 947	uqs:a	(JZ)Z
    //   3135: pop
    //   3136: aload_0
    //   3137: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   3140: invokevirtual 161	uqq:a	()V
    //   3143: aload_0
    //   3144: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   3147: aload_0
    //   3148: getfield 63	uqo:jdField_b_of_type_Int	I
    //   3151: aload_2
    //   3152: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   3155: aload_3
    //   3156: invokevirtual 951	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   3159: aload_0
    //   3160: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   3163: iconst_1
    //   3164: invokevirtual 953	uqq:c	(Z)V
    //   3167: aload_3
    //   3168: getfield 916	android/media/MediaCodec$BufferInfo:flags	I
    //   3171: iconst_4
    //   3172: iand
    //   3173: ifeq +21 -> 3194
    //   3176: aload_0
    //   3177: iconst_1
    //   3178: putfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   3181: aload_0
    //   3182: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3185: ldc_w 761
    //   3188: ldc_w 955
    //   3191: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3194: aload_0
    //   3195: getfield 70	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   3198: aload_2
    //   3199: invokevirtual 926	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;)V
    //   3202: goto -2267 -> 935
    //   3205: aload_0
    //   3206: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3209: iconst_0
    //   3210: putfield 935	uqs:jdField_b_of_type_Boolean	Z
    //   3213: goto -146 -> 3067
    //   3216: aload_0
    //   3217: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3220: ldc_w 761
    //   3223: ldc_w 957
    //   3226: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3229: goto -62 -> 3167
    //   3232: astore_2
    //   3233: aload_2
    //   3234: invokevirtual 486	java/lang/IllegalStateException:printStackTrace	()V
    //   3237: aload_0
    //   3238: bipush -22
    //   3240: putfield 57	uqo:jdField_a_of_type_Int	I
    //   3243: aload_0
    //   3244: aload_0
    //   3245: getfield 57	uqo:jdField_a_of_type_Int	I
    //   3248: iconst_0
    //   3249: invokevirtual 572	uqo:b	(II)V
    //   3252: goto -2144 -> 1108
    //   3255: aload_2
    //   3256: getfield 893	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   3259: astore_3
    //   3260: aload_2
    //   3261: getfield 744	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   3264: istore 4
    //   3266: iload 4
    //   3268: iconst_m1
    //   3269: if_icmpne +19 -> 3288
    //   3272: aload_0
    //   3273: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3276: ldc_w 769
    //   3279: ldc_w 895
    //   3282: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3285: goto -2258 -> 1027
    //   3288: iload 4
    //   3290: bipush -3
    //   3292: if_icmpne +19 -> 3311
    //   3295: aload_0
    //   3296: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3299: ldc_w 769
    //   3302: ldc_w 959
    //   3305: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3308: goto -2281 -> 1027
    //   3311: iload 4
    //   3313: bipush -2
    //   3315: if_icmpne +44 -> 3359
    //   3318: aload_0
    //   3319: aload_0
    //   3320: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   3323: invokevirtual 900	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	()Landroid/media/MediaCodec;
    //   3326: invokevirtual 906	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   3329: putfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   3332: aload_0
    //   3333: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3336: aload_0
    //   3337: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   3340: invokevirtual 961	uqs:b	(Landroid/media/MediaFormat;)V
    //   3343: aload_0
    //   3344: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3347: ldc_w 769
    //   3350: ldc_w 963
    //   3353: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3356: goto -2329 -> 1027
    //   3359: aload_3
    //   3360: getfield 916	android/media/MediaCodec$BufferInfo:flags	I
    //   3363: iconst_2
    //   3364: iand
    //   3365: ifeq +44 -> 3409
    //   3368: aload_0
    //   3369: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3372: ldc_w 769
    //   3375: ldc_w 965
    //   3378: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3381: aload_0
    //   3382: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3385: aload_2
    //   3386: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   3389: aload_3
    //   3390: ldc_w 967
    //   3393: bipush 10
    //   3395: invokevirtual 923	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;Ljava/lang/String;I)V
    //   3398: aload_0
    //   3399: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   3402: aload_2
    //   3403: invokevirtual 926	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;)V
    //   3406: goto -2379 -> 1027
    //   3409: aload_0
    //   3410: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3413: ldc_w 769
    //   3416: new 192	java/lang/StringBuilder
    //   3419: dup
    //   3420: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3423: ldc_w 928
    //   3426: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: aload_3
    //   3430: getfield 930	android/media/MediaCodec$BufferInfo:size	I
    //   3433: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3436: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3439: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3442: aload_3
    //   3443: getfield 930	android/media/MediaCodec$BufferInfo:size	I
    //   3446: ifeq +130 -> 3576
    //   3449: aload_0
    //   3450: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   3453: iconst_0
    //   3454: invokevirtual 932	uqq:b	(Z)V
    //   3457: aload_0
    //   3458: aload_0
    //   3459: getfield 382	uqo:jdField_l_of_type_Int	I
    //   3462: iconst_1
    //   3463: iadd
    //   3464: putfield 382	uqo:jdField_l_of_type_Int	I
    //   3467: aload_0
    //   3468: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   3471: ifnull +143 -> 3614
    //   3474: aload_0
    //   3475: aload_0
    //   3476: getfield 148	uqo:jdField_m_of_type_Int	I
    //   3479: iconst_1
    //   3480: iadd
    //   3481: putfield 148	uqo:jdField_m_of_type_Int	I
    //   3484: aload_0
    //   3485: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3488: ldc_w 969
    //   3491: new 192	java/lang/StringBuilder
    //   3494: dup
    //   3495: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3498: ldc_w 939
    //   3501: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: aload_0
    //   3505: getfield 65	uqo:jdField_c_of_type_Int	I
    //   3508: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3511: ldc_w 941
    //   3514: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3517: aload_3
    //   3518: getfield 944	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3521: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3524: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3527: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3530: aload_0
    //   3531: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3534: aload_3
    //   3535: getfield 944	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3538: iconst_0
    //   3539: invokevirtual 947	uqs:a	(JZ)Z
    //   3542: ifne +34 -> 3576
    //   3545: aload_0
    //   3546: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   3549: invokevirtual 161	uqq:a	()V
    //   3552: aload_0
    //   3553: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   3556: aload_0
    //   3557: getfield 65	uqo:jdField_c_of_type_Int	I
    //   3560: aload_2
    //   3561: getfield 812	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   3564: aload_3
    //   3565: invokevirtual 951	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   3568: aload_0
    //   3569: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   3572: iconst_0
    //   3573: invokevirtual 953	uqq:c	(Z)V
    //   3576: aload_3
    //   3577: getfield 916	android/media/MediaCodec$BufferInfo:flags	I
    //   3580: iconst_4
    //   3581: iand
    //   3582: ifeq +21 -> 3603
    //   3585: aload_0
    //   3586: iconst_1
    //   3587: putfield 125	uqo:jdField_e_of_type_Boolean	Z
    //   3590: aload_0
    //   3591: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3594: ldc_w 769
    //   3597: ldc_w 955
    //   3600: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3603: aload_0
    //   3604: getfield 72	uqo:jdField_b_of_type_ComTencentMobileqqShortvideoHwcodecSVHwCodec	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;
    //   3607: aload_2
    //   3608: invokevirtual 926	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData;)V
    //   3611: goto -2584 -> 1027
    //   3614: aload_0
    //   3615: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3618: ldc_w 769
    //   3621: ldc_w 971
    //   3624: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3627: goto -51 -> 3576
    //   3630: aload_0
    //   3631: getfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   3634: ifeq +574 -> 4208
    //   3637: aload_0
    //   3638: getfield 125	uqo:jdField_e_of_type_Boolean	Z
    //   3641: ifeq +567 -> 4208
    //   3644: aload_0
    //   3645: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3648: invokevirtual 973	uqs:c	()Z
    //   3651: istore 11
    //   3653: aload_0
    //   3654: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   3657: invokevirtual 974	uqs:a	()V
    //   3660: iload 11
    //   3662: ifne +52 -> 3714
    //   3665: aload_0
    //   3666: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3669: ldc_w 976
    //   3672: new 192	java/lang/StringBuilder
    //   3675: dup
    //   3676: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3679: ldc_w 978
    //   3682: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: iload 11
    //   3687: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3690: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3693: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3696: aload_0
    //   3697: bipush -14
    //   3699: putfield 57	uqo:jdField_a_of_type_Int	I
    //   3702: aload_0
    //   3703: aload_0
    //   3704: getfield 57	uqo:jdField_a_of_type_Int	I
    //   3707: iconst_0
    //   3708: invokevirtual 572	uqo:b	(II)V
    //   3711: goto -2603 -> 1108
    //   3714: aload_0
    //   3715: iconst_1
    //   3716: invokevirtual 795	uqo:a	(Z)Z
    //   3719: ifeq +21 -> 3740
    //   3722: aload_0
    //   3723: bipush -14
    //   3725: putfield 57	uqo:jdField_a_of_type_Int	I
    //   3728: aload_0
    //   3729: aload_0
    //   3730: getfield 57	uqo:jdField_a_of_type_Int	I
    //   3733: iconst_1
    //   3734: invokevirtual 572	uqo:b	(II)V
    //   3737: goto -2629 -> 1108
    //   3740: aload_0
    //   3741: getfield 137	uqo:o	Z
    //   3744: ifeq +340 -> 4084
    //   3747: aload_0
    //   3748: getfield 139	uqo:jdField_g_of_type_Int	I
    //   3751: iconst_1
    //   3752: iadd
    //   3753: aload_0
    //   3754: getfield 355	uqo:jdField_f_of_type_Int	I
    //   3757: if_icmpge +149 -> 3906
    //   3760: aload_0
    //   3761: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3764: invokevirtual 616	java/util/ArrayList:size	()I
    //   3767: aload_0
    //   3768: getfield 355	uqo:jdField_f_of_type_Int	I
    //   3771: iconst_1
    //   3772: isub
    //   3773: if_icmpeq +21 -> 3794
    //   3776: aload_0
    //   3777: bipush -15
    //   3779: putfield 57	uqo:jdField_a_of_type_Int	I
    //   3782: aload_0
    //   3783: aload_0
    //   3784: getfield 57	uqo:jdField_a_of_type_Int	I
    //   3787: iconst_0
    //   3788: invokevirtual 572	uqo:b	(II)V
    //   3791: goto -2683 -> 1108
    //   3794: iconst_0
    //   3795: istore 4
    //   3797: iload 4
    //   3799: aload_0
    //   3800: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3803: invokevirtual 616	java/util/ArrayList:size	()I
    //   3806: if_icmpge +100 -> 3906
    //   3809: aload_0
    //   3810: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3813: ldc_w 578
    //   3816: new 192	java/lang/StringBuilder
    //   3819: dup
    //   3820: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3823: ldc_w 980
    //   3826: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3829: iload 4
    //   3831: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3834: ldc_w 982
    //   3837: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: aload_0
    //   3841: getfield 139	uqo:jdField_g_of_type_Int	I
    //   3844: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3847: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3850: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3853: aload_0
    //   3854: aload_0
    //   3855: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3858: iload 4
    //   3860: invokevirtual 627	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3863: checkcast 629	java/lang/String
    //   3866: iload 4
    //   3868: iconst_1
    //   3869: iadd
    //   3870: aload_0
    //   3871: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3874: invokestatic 516	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   3877: aload_0
    //   3878: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3881: invokestatic 518	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:d	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   3884: invokevirtual 983	uqo:a	(Ljava/lang/String;III)V
    //   3887: aload_0
    //   3888: aload_0
    //   3889: getfield 139	uqo:jdField_g_of_type_Int	I
    //   3892: iconst_1
    //   3893: iadd
    //   3894: putfield 139	uqo:jdField_g_of_type_Int	I
    //   3897: iload 4
    //   3899: iconst_1
    //   3900: iadd
    //   3901: istore 4
    //   3903: goto -106 -> 3797
    //   3906: aload_0
    //   3907: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3910: ldc_w 578
    //   3913: new 192	java/lang/StringBuilder
    //   3916: dup
    //   3917: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   3920: ldc_w 985
    //   3923: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3926: aload_0
    //   3927: getfield 139	uqo:jdField_g_of_type_Int	I
    //   3930: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3933: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3936: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   3939: aload_0
    //   3940: aload_0
    //   3941: getfield 357	uqo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3944: aload_0
    //   3945: getfield 355	uqo:jdField_f_of_type_Int	I
    //   3948: aload_0
    //   3949: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3952: invokestatic 516	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   3955: aload_0
    //   3956: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3959: invokestatic 518	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:d	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   3962: invokevirtual 983	uqo:a	(Ljava/lang/String;III)V
    //   3965: aload_0
    //   3966: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3969: aload_0
    //   3970: getfield 357	uqo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3973: invokevirtual 989	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3976: pop
    //   3977: aload_0
    //   3978: aload_0
    //   3979: getfield 139	uqo:jdField_g_of_type_Int	I
    //   3982: iconst_1
    //   3983: iadd
    //   3984: putfield 139	uqo:jdField_g_of_type_Int	I
    //   3987: aload_0
    //   3988: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   3991: invokestatic 326	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   3994: ifne -2886 -> 1108
    //   3997: aload_0
    //   3998: ldc_w 991
    //   4001: invokevirtual 993	uqo:a	(Ljava/lang/String;)Z
    //   4004: ifne -2896 -> 1108
    //   4007: aload_0
    //   4008: iconst_1
    //   4009: invokevirtual 694	uqo:a	(Z)V
    //   4012: aload_0
    //   4013: iconst_0
    //   4014: invokevirtual 694	uqo:a	(Z)V
    //   4017: aload_0
    //   4018: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4021: ldc_w 783
    //   4024: new 192	java/lang/StringBuilder
    //   4027: dup
    //   4028: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4031: ldc_w 995
    //   4034: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4037: aload_0
    //   4038: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4041: invokevirtual 786	uqq:toString	()Ljava/lang/String;
    //   4044: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4047: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4050: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4053: aload_0
    //   4054: invokevirtual 121	uqo:a	()V
    //   4057: aload_0
    //   4058: aload_0
    //   4059: invokevirtual 997	uqo:e	()I
    //   4062: putfield 57	uqo:jdField_a_of_type_Int	I
    //   4065: aload_0
    //   4066: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4069: ifeq +79 -> 4148
    //   4072: aload_0
    //   4073: aload_0
    //   4074: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4077: iconst_0
    //   4078: invokevirtual 572	uqo:b	(II)V
    //   4081: goto -2973 -> 1108
    //   4084: aload_0
    //   4085: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4088: aload_0
    //   4089: getfield 357	uqo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4092: invokevirtual 989	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4095: pop
    //   4096: aload_0
    //   4097: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4100: ldc_w 578
    //   4103: new 192	java/lang/StringBuilder
    //   4106: dup
    //   4107: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4110: ldc_w 999
    //   4113: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4116: aload_0
    //   4117: getfield 137	uqo:o	Z
    //   4120: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4123: ldc_w 875
    //   4126: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4129: aload_0
    //   4130: getfield 82	uqo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4133: invokevirtual 616	java/util/ArrayList:size	()I
    //   4136: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4139: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4142: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4145: goto -158 -> 3987
    //   4148: aload_0
    //   4149: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4152: ifeq +30 -> 4182
    //   4155: aload_0
    //   4156: aload_0
    //   4157: invokevirtual 1001	uqo:f	()I
    //   4160: putfield 57	uqo:jdField_a_of_type_Int	I
    //   4163: aload_0
    //   4164: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4167: ifeq +15 -> 4182
    //   4170: aload_0
    //   4171: aload_0
    //   4172: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4175: iconst_0
    //   4176: invokevirtual 572	uqo:b	(II)V
    //   4179: goto -3071 -> 1108
    //   4182: aload_0
    //   4183: iconst_0
    //   4184: putfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   4187: aload_0
    //   4188: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4191: ifeq +8 -> 4199
    //   4194: aload_0
    //   4195: iconst_0
    //   4196: putfield 125	uqo:jdField_e_of_type_Boolean	Z
    //   4199: aload_0
    //   4200: invokevirtual 1003	uqo:l	()V
    //   4203: aload_0
    //   4204: iconst_1
    //   4205: putfield 131	uqo:jdField_k_of_type_Boolean	Z
    //   4208: aload_0
    //   4209: getfield 131	uqo:jdField_k_of_type_Boolean	Z
    //   4212: ifeq +417 -> 4629
    //   4215: aload_0
    //   4216: ldc_w 1005
    //   4219: invokevirtual 993	uqo:a	(Ljava/lang/String;)Z
    //   4222: ifne -3114 -> 1108
    //   4225: iconst_0
    //   4226: istore 11
    //   4228: aload_0
    //   4229: aload_0
    //   4230: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4233: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   4236: invokevirtual 1007	uqo:a	(Ljava/util/ArrayList;)Z
    //   4239: istore 12
    //   4241: aload_0
    //   4242: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4245: ifeq +16 -> 4261
    //   4248: aload_0
    //   4249: aload_0
    //   4250: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4253: invokestatic 446	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   4256: invokevirtual 1007	uqo:a	(Ljava/util/ArrayList;)Z
    //   4259: istore 11
    //   4261: aload_0
    //   4262: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4265: invokestatic 361	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   4268: ifeq +76 -> 4344
    //   4271: iload 12
    //   4273: ifne +8 -> 4281
    //   4276: aload_0
    //   4277: iconst_0
    //   4278: putfield 59	uqo:jdField_f_of_type_Boolean	Z
    //   4281: iload 11
    //   4283: ifne +8 -> 4291
    //   4286: aload_0
    //   4287: iconst_0
    //   4288: putfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4291: aload_0
    //   4292: getfield 59	uqo:jdField_f_of_type_Boolean	Z
    //   4295: ifne +49 -> 4344
    //   4298: aload_0
    //   4299: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4302: ifne +42 -> 4344
    //   4305: aload_0
    //   4306: new 192	java/lang/StringBuilder
    //   4309: dup
    //   4310: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4313: ldc_w 1009
    //   4316: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4319: iload 12
    //   4321: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4324: ldc_w 1011
    //   4327: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4330: iload 11
    //   4332: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4335: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4338: invokevirtual 438	uqo:a	(Ljava/lang/String;)V
    //   4341: goto -3233 -> 1108
    //   4344: aload_0
    //   4345: getfield 59	uqo:jdField_f_of_type_Boolean	Z
    //   4348: ifne +16 -> 4364
    //   4351: iconst_1
    //   4352: istore 12
    //   4354: aload_0
    //   4355: iconst_1
    //   4356: putfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   4359: aload_0
    //   4360: aconst_null
    //   4361: putfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4364: aload_0
    //   4365: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4368: ifne +16 -> 4384
    //   4371: iconst_1
    //   4372: istore 11
    //   4374: aload_0
    //   4375: iconst_1
    //   4376: putfield 125	uqo:jdField_e_of_type_Boolean	Z
    //   4379: aload_0
    //   4380: aconst_null
    //   4381: putfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4384: iload 12
    //   4386: ifeq +235 -> 4621
    //   4389: iload 11
    //   4391: ifeq +230 -> 4621
    //   4394: aload_0
    //   4395: iconst_0
    //   4396: putfield 720	uqo:jdField_b_of_type_Boolean	Z
    //   4399: aload_0
    //   4400: iconst_0
    //   4401: putfield 123	uqo:jdField_c_of_type_Boolean	Z
    //   4404: aload_0
    //   4405: iconst_1
    //   4406: putfield 84	uqo:jdField_l_of_type_Boolean	Z
    //   4409: aload_0
    //   4410: iconst_0
    //   4411: putfield 131	uqo:jdField_k_of_type_Boolean	Z
    //   4414: aload_0
    //   4415: getfield 93	uqo:jdField_a_of_type_Uqs	Luqs;
    //   4418: ldc_w 1013
    //   4421: invokevirtual 1014	uqs:a	(Ljava/lang/String;)V
    //   4424: aload_0
    //   4425: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4428: ldc_w 937
    //   4431: new 192	java/lang/StringBuilder
    //   4434: dup
    //   4435: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4438: ldc_w 939
    //   4441: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4444: aload_0
    //   4445: getfield 63	uqo:jdField_b_of_type_Int	I
    //   4448: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4451: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4454: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4457: aload_0
    //   4458: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4461: ldc_w 969
    //   4464: new 192	java/lang/StringBuilder
    //   4467: dup
    //   4468: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4471: ldc_w 939
    //   4474: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4477: aload_0
    //   4478: getfield 65	uqo:jdField_c_of_type_Int	I
    //   4481: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4484: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4487: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4490: aload_0
    //   4491: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4494: ldc_w 736
    //   4497: ldc_w 1016
    //   4500: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4503: aload_0
    //   4504: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4507: ldc_w 749
    //   4510: ldc_w 1016
    //   4513: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4516: aload_0
    //   4517: getfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   4520: ifne -4170 -> 350
    //   4523: aload_0
    //   4524: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4527: ifnonnull +10 -> 4537
    //   4530: aload_0
    //   4531: getfield 59	uqo:jdField_f_of_type_Boolean	Z
    //   4534: ifne -4184 -> 350
    //   4537: aload_0
    //   4538: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4541: ifnonnull +10 -> 4551
    //   4544: aload_0
    //   4545: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4548: ifne -4198 -> 350
    //   4551: aload_0
    //   4552: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4555: invokevirtual 161	uqq:a	()V
    //   4558: aload_0
    //   4559: new 477	android/media/MediaMuxer
    //   4562: dup
    //   4563: aload_0
    //   4564: getfield 357	uqo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4567: iconst_0
    //   4568: invokespecial 1018	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   4571: putfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   4574: aload_0
    //   4575: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   4578: aload_0
    //   4579: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4582: invokestatic 1020	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:e	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)I
    //   4585: invokevirtual 1023	android/media/MediaMuxer:setOrientationHint	(I)V
    //   4588: aload_0
    //   4589: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4592: aload_0
    //   4593: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4596: invokevirtual 171	uqq:a	()J
    //   4599: putfield 1025	uqq:n	J
    //   4602: aload_0
    //   4603: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4606: ifeq +250 -> 4856
    //   4609: aload_0
    //   4610: aload_0
    //   4611: getfield 57	uqo:jdField_a_of_type_Int	I
    //   4614: iconst_0
    //   4615: invokevirtual 572	uqo:b	(II)V
    //   4618: goto -3510 -> 1108
    //   4621: aload_0
    //   4622: iconst_0
    //   4623: putfield 84	uqo:jdField_l_of_type_Boolean	Z
    //   4626: goto -110 -> 4516
    //   4629: aload_0
    //   4630: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4633: invokestatic 361	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Z
    //   4636: ifeq -120 -> 4516
    //   4639: iconst_0
    //   4640: istore 4
    //   4642: aload_0
    //   4643: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4646: aload_0
    //   4647: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4650: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   4653: invokevirtual 444	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)I
    //   4656: istore 5
    //   4658: aload_0
    //   4659: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4662: ifeq +19 -> 4681
    //   4665: aload_0
    //   4666: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4669: aload_0
    //   4670: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4673: invokestatic 446	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   4676: invokevirtual 444	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/util/ArrayList;)I
    //   4679: istore 4
    //   4681: aload_0
    //   4682: new 192	java/lang/StringBuilder
    //   4685: dup
    //   4686: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4689: ldc_w 1027
    //   4692: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: iload 5
    //   4697: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4700: ldc_w 1029
    //   4703: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4706: iload 4
    //   4708: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4711: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4714: invokevirtual 438	uqo:a	(Ljava/lang/String;)V
    //   4717: iload 5
    //   4719: ifgt +8 -> 4727
    //   4722: iload 4
    //   4724: ifle +28 -> 4752
    //   4727: aload_0
    //   4728: getfield 61	uqo:jdField_g_of_type_Boolean	Z
    //   4731: ifeq -215 -> 4516
    //   4734: iload 4
    //   4736: ifgt -220 -> 4516
    //   4739: aload_0
    //   4740: getfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   4743: ifeq -227 -> 4516
    //   4746: iload 5
    //   4748: iconst_3
    //   4749: if_icmpgt -233 -> 4516
    //   4752: iload 5
    //   4754: ifle +61 -> 4815
    //   4757: aload_0
    //   4758: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4761: ldc_w 1031
    //   4764: new 192	java/lang/StringBuilder
    //   4767: dup
    //   4768: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4771: ldc_w 1033
    //   4774: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4777: iload 5
    //   4779: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4782: ldc_w 1035
    //   4785: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4788: aload_0
    //   4789: getfield 759	uqo:jdField_d_of_type_Boolean	Z
    //   4792: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4795: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4798: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4801: aload_0
    //   4802: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4805: aload_0
    //   4806: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4809: invokestatic 441	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;)Ljava/util/ArrayList;
    //   4812: invokevirtual 1037	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:b	(Ljava/util/ArrayList;)V
    //   4815: aload_0
    //   4816: ldc_w 1031
    //   4819: invokevirtual 438	uqo:a	(Ljava/lang/String;)V
    //   4822: aload_0
    //   4823: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4826: invokevirtual 1038	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:d	()V
    //   4829: goto -313 -> 4516
    //   4832: astore_2
    //   4833: aload_2
    //   4834: invokevirtual 1039	java/io/IOException:printStackTrace	()V
    //   4837: aload_0
    //   4838: aconst_null
    //   4839: putfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   4842: aload_0
    //   4843: iconst_0
    //   4844: putfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   4847: aload_0
    //   4848: bipush -11
    //   4850: putfield 57	uqo:jdField_a_of_type_Int	I
    //   4853: goto -265 -> 4588
    //   4856: aload_0
    //   4857: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4860: invokevirtual 161	uqq:a	()V
    //   4863: aload_0
    //   4864: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4867: ifnull +51 -> 4918
    //   4870: aload_0
    //   4871: aload_0
    //   4872: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   4875: aload_0
    //   4876: getfield 567	uqo:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4879: invokevirtual 1043	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   4882: putfield 63	uqo:jdField_b_of_type_Int	I
    //   4885: aload_0
    //   4886: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4889: ldc_w 466
    //   4892: new 192	java/lang/StringBuilder
    //   4895: dup
    //   4896: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4899: ldc_w 1045
    //   4902: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4905: aload_0
    //   4906: getfield 63	uqo:jdField_b_of_type_Int	I
    //   4909: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4912: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4915: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4918: aload_0
    //   4919: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4922: ifnull +51 -> 4973
    //   4925: aload_0
    //   4926: aload_0
    //   4927: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   4930: aload_0
    //   4931: getfield 601	uqo:jdField_b_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   4934: invokevirtual 1043	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   4937: putfield 65	uqo:jdField_c_of_type_Int	I
    //   4940: aload_0
    //   4941: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4944: ldc_w 466
    //   4947: new 192	java/lang/StringBuilder
    //   4950: dup
    //   4951: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   4954: ldc_w 1047
    //   4957: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4960: aload_0
    //   4961: getfield 65	uqo:jdField_c_of_type_Int	I
    //   4964: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4967: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4970: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4973: aload_0
    //   4974: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4977: aload_0
    //   4978: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   4981: invokevirtual 171	uqq:a	()J
    //   4984: putfield 1049	uqq:o	J
    //   4987: aload_0
    //   4988: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   4991: ldc_w 466
    //   4994: ldc_w 1051
    //   4997: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5000: aload_0
    //   5001: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   5004: invokevirtual 161	uqq:a	()V
    //   5007: aload_0
    //   5008: getfield 475	uqo:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   5011: invokevirtual 1054	android/media/MediaMuxer:start	()V
    //   5014: aload_0
    //   5015: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   5018: aload_0
    //   5019: getfield 98	uqo:jdField_a_of_type_Uqq	Luqq;
    //   5022: invokevirtual 171	uqq:a	()J
    //   5025: putfield 1056	uqq:p	J
    //   5028: aload_0
    //   5029: iconst_1
    //   5030: putfield 469	uqo:jdField_a_of_type_Boolean	Z
    //   5033: goto -4683 -> 350
    //   5036: aload_0
    //   5037: invokevirtual 1057	uqo:c	()V
    //   5040: goto -3814 -> 1226
    //   5043: aload_0
    //   5044: getfield 47	uqo:jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder	Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
    //   5047: ldc_w 574
    //   5050: ldc_w 1059
    //   5053: invokevirtual 209	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   5056: aload_0
    //   5057: invokevirtual 1061	uqo:h	()V
    //   5060: goto -3781 -> 1279
    //   5063: astore_3
    //   5064: goto -4955 -> 109
    //   5067: lload 9
    //   5069: lstore 7
    //   5071: goto -2662 -> 2409
    //   5074: goto -2873 -> 2201
    //   5077: lload 9
    //   5079: lstore 7
    //   5081: goto -3474 -> 1607
    //   5084: goto -3578 -> 1506
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5087	0	this	uqo
    //   2398	6	1	f1	float
    //   87	924	2	localObject1	Object
    //   1359	2	2	localIllegalStateException1	IllegalStateException
    //   1393	366	2	localObject2	Object
    //   1784	197	2	localIllegalStateException2	IllegalStateException
    //   2061	2	2	localIllegalStateException3	IllegalStateException
    //   2095	531	2	localObject3	Object
    //   2771	428	2	localIllegalStateException4	IllegalStateException
    //   3232	376	2	localIllegalStateException5	IllegalStateException
    //   4832	2	2	localIOException	java.io.IOException
    //   122	4	3	localObject4	Object
    //   351	2205	3	localBufferData	com.tencent.mobileqq.shortvideo.hwcodec.SVHwCodec.BufferData
    //   2591	127	3	localIllegalStateException6	IllegalStateException
    //   2798	779	3	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   5063	1	3	localInterruptedException	InterruptedException
    //   1059	3676	4	i1	int
    //   1539	3239	5	i2	int
    //   2234	405	6	i3	int
    //   519	4561	7	l1	long
    //   1585	3493	9	l2	long
    //   93	4297	11	bool1	boolean
    //   4239	146	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   90	95	122	finally
    //   100	109	122	finally
    //   109	121	122	finally
    //   123	125	122	finally
    //   127	129	122	finally
    //   515	562	1359	java/lang/IllegalStateException
    //   1649	1664	1784	java/lang/IllegalStateException
    //   660	707	2061	java/lang/IllegalStateException
    //   2451	2464	2591	java/lang/IllegalStateException
    //   871	918	2771	java/lang/IllegalStateException
    //   963	1010	3232	java/lang/IllegalStateException
    //   4558	4588	4832	java/io/IOException
    //   100	109	5063	java/lang/InterruptedException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */