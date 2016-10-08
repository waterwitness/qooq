package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.PingProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.DESUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import uzz;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
{
  public static WeakNetLearner a;
  private static final Pattern a;
  static final int aK = 1;
  static final int aL = 2;
  static final int aM = 3;
  static final int aN = 4;
  private static final int be = 1600000226;
  public static final String i = "c2cpicdw.qpic.cn";
  public static final String j = "gchat.qpic.cn";
  protected TransferRequest.PicDownExtraInfo a;
  protected byte[] a;
  protected int aJ;
  protected byte[] b;
  protected long c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  protected String k = "";
  protected String l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner = new WeakNetLearner(BaseApplication.getContext(), new uzz());
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  }
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    g();
  }
  
  private boolean a(NetResp paramNetResp)
  {
    if (paramNetResp != null) {
      try
      {
        if (paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_b_of_type_JavaLangString, localOptions);
          if (localOptions.outHeight > 0)
          {
            int m = localOptions.outWidth;
            if (m > 0) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramNetResp)
      {
        paramNetResp.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void b(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore_2
    //   13: iconst_2
    //   14: newarray <illegal type>
    //   16: astore 9
    //   18: aload 9
    //   20: dup
    //   21: iconst_0
    //   22: ldc -117
    //   24: bastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc -116
    //   29: bastore
    //   30: pop
    //   31: aload_1
    //   32: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   35: ifnull +74 -> 109
    //   38: aload_1
    //   39: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   42: getfield 142	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   45: ifnull +64 -> 109
    //   48: aload_1
    //   49: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   52: getfield 142	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 148	java/lang/String:length	()I
    //   58: ifeq +51 -> 109
    //   61: aload_1
    //   62: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   65: getfield 114	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   68: ifnull +41 -> 109
    //   71: aload_1
    //   72: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   75: getfield 114	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 148	java/lang/String:length	()I
    //   81: ifeq +28 -> 109
    //   84: aload_1
    //   85: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   88: getfield 142	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: astore 8
    //   93: aload_1
    //   94: getfield 110	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   97: getfield 114	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   100: astore 7
    //   102: aload_0
    //   103: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   106: ifnonnull +4 -> 110
    //   109: return
    //   110: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +99 -> 212
    //   116: aload_0
    //   117: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   120: getfield 161	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Int	I
    //   123: aload_0
    //   124: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   127: getfield 163	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Boolean	Z
    //   130: aload_0
    //   131: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   134: getfield 165	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   137: aload_0
    //   138: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   141: getfield 167	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   144: invokestatic 171	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   147: ldc -83
    //   149: new 175	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   156: ldc -78
    //   158: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   165: getfield 184	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   168: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc -67
    //   173: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   180: getfield 191	com/tencent/mobileqq/transfile/TransferRequest:j	I
    //   183: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc -63
    //   188: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 8
    //   193: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc -61
    //   198: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 7
    //   203: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 204	com/tencent/mobileqq/transfile/RichMediaUtil:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   217: invokevirtual 207	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/TransferRequest;)I
    //   220: istore 10
    //   222: iload 10
    //   224: iconst_4
    //   225: if_icmpne +400 -> 625
    //   228: new 175	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   235: aload 7
    //   237: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc -47
    //   242: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore 5
    //   250: aload 7
    //   252: aload 5
    //   254: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   257: pop
    //   258: new 216	java/io/File
    //   261: dup
    //   262: aload 5
    //   264: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: new 216	java/io/File
    //   271: dup
    //   272: aload 8
    //   274: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore 6
    //   279: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   282: ifeq +42 -> 324
    //   285: ldc -32
    //   287: iconst_4
    //   288: new 175	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   295: ldc -30
    //   297: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 6
    //   302: invokevirtual 229	java/io/File:length	()J
    //   305: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: ldc -22
    //   310: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 7
    //   315: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_1
    //   325: invokevirtual 240	java/io/File:exists	()Z
    //   328: ifeq -219 -> 109
    //   331: aload 6
    //   333: invokevirtual 240	java/io/File:exists	()Z
    //   336: ifeq -227 -> 109
    //   339: new 242	java/io/RandomAccessFile
    //   342: dup
    //   343: aload_1
    //   344: ldc -12
    //   346: invokespecial 247	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   349: astore_1
    //   350: aload_1
    //   351: aload_0
    //   352: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   355: getfield 184	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   358: i2l
    //   359: invokevirtual 251	java/io/RandomAccessFile:seek	(J)V
    //   362: new 253	java/io/FileInputStream
    //   365: dup
    //   366: aload 6
    //   368: invokespecial 256	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   371: astore_3
    //   372: sipush 1024
    //   375: newarray <illegal type>
    //   377: astore_2
    //   378: aload_3
    //   379: aload_2
    //   380: invokevirtual 260	java/io/FileInputStream:read	([B)I
    //   383: istore 10
    //   385: iload 10
    //   387: ifle +75 -> 462
    //   390: aload_1
    //   391: aload_2
    //   392: iconst_0
    //   393: iload 10
    //   395: invokevirtual 264	java/io/RandomAccessFile:write	([BII)V
    //   398: goto -20 -> 378
    //   401: astore_2
    //   402: aload_1
    //   403: astore_2
    //   404: aload_3
    //   405: astore_1
    //   406: aload_2
    //   407: ifnull +7 -> 414
    //   410: aload_2
    //   411: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   414: aload_1
    //   415: ifnull +7 -> 422
    //   418: aload_1
    //   419: invokevirtual 268	java/io/FileInputStream:close	()V
    //   422: aload 6
    //   424: invokevirtual 271	java/io/File:delete	()Z
    //   427: pop
    //   428: aload 5
    //   430: aload 7
    //   432: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   435: ifne -326 -> 109
    //   438: aload 5
    //   440: aload 7
    //   442: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   445: ifeq +87 -> 532
    //   448: new 216	java/io/File
    //   451: dup
    //   452: aload 5
    //   454: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   457: invokevirtual 271	java/io/File:delete	()Z
    //   460: pop
    //   461: return
    //   462: aload_1
    //   463: ifnull +7 -> 470
    //   466: aload_1
    //   467: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   470: aload_3
    //   471: ifnull +7 -> 478
    //   474: aload_3
    //   475: invokevirtual 268	java/io/FileInputStream:close	()V
    //   478: aload 6
    //   480: invokevirtual 271	java/io/File:delete	()Z
    //   483: pop
    //   484: aload 5
    //   486: aload 7
    //   488: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   491: ifne -382 -> 109
    //   494: aload 5
    //   496: aload 7
    //   498: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   501: ifeq +17 -> 518
    //   504: new 216	java/io/File
    //   507: dup
    //   508: aload 5
    //   510: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: invokevirtual 271	java/io/File:delete	()Z
    //   516: pop
    //   517: return
    //   518: new 216	java/io/File
    //   521: dup
    //   522: aload 5
    //   524: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   527: invokevirtual 271	java/io/File:delete	()Z
    //   530: pop
    //   531: return
    //   532: new 216	java/io/File
    //   535: dup
    //   536: aload 5
    //   538: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   541: invokevirtual 271	java/io/File:delete	()Z
    //   544: pop
    //   545: return
    //   546: astore_2
    //   547: aconst_null
    //   548: astore_1
    //   549: aload 4
    //   551: astore_3
    //   552: aload_1
    //   553: ifnull +7 -> 560
    //   556: aload_1
    //   557: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   560: aload_3
    //   561: ifnull +7 -> 568
    //   564: aload_3
    //   565: invokevirtual 268	java/io/FileInputStream:close	()V
    //   568: aload 6
    //   570: invokevirtual 271	java/io/File:delete	()Z
    //   573: pop
    //   574: aload 5
    //   576: aload 7
    //   578: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   581: ifne +26 -> 607
    //   584: aload 5
    //   586: aload 7
    //   588: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   591: ifeq +18 -> 609
    //   594: new 216	java/io/File
    //   597: dup
    //   598: aload 5
    //   600: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: invokevirtual 271	java/io/File:delete	()Z
    //   606: pop
    //   607: aload_2
    //   608: athrow
    //   609: new 216	java/io/File
    //   612: dup
    //   613: aload 5
    //   615: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   618: invokevirtual 271	java/io/File:delete	()Z
    //   621: pop
    //   622: goto -15 -> 607
    //   625: iload 10
    //   627: iconst_2
    //   628: if_icmpne +231 -> 859
    //   631: new 216	java/io/File
    //   634: dup
    //   635: aload 8
    //   637: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   640: astore_1
    //   641: new 216	java/io/File
    //   644: dup
    //   645: aload 7
    //   647: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   650: astore_2
    //   651: aload_2
    //   652: invokevirtual 240	java/io/File:exists	()Z
    //   655: ifeq +8 -> 663
    //   658: aload_2
    //   659: invokevirtual 271	java/io/File:delete	()Z
    //   662: pop
    //   663: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   666: ifeq +42 -> 708
    //   669: ldc -32
    //   671: iconst_4
    //   672: new 175	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 275
    //   682: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 229	java/io/File:length	()J
    //   689: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   692: ldc -22
    //   694: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 7
    //   699: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: aload_1
    //   709: invokevirtual 240	java/io/File:exists	()Z
    //   712: ifeq -603 -> 109
    //   715: new 242	java/io/RandomAccessFile
    //   718: dup
    //   719: aload_1
    //   720: ldc -12
    //   722: invokespecial 247	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   725: astore_2
    //   726: aload_2
    //   727: aload_2
    //   728: invokevirtual 276	java/io/RandomAccessFile:length	()J
    //   731: invokevirtual 251	java/io/RandomAccessFile:seek	(J)V
    //   734: aload_2
    //   735: aload 9
    //   737: invokevirtual 279	java/io/RandomAccessFile:write	([B)V
    //   740: aload_2
    //   741: ifnull +7 -> 748
    //   744: aload_2
    //   745: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   748: aload 8
    //   750: aload 7
    //   752: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   755: ifne -646 -> 109
    //   758: aload 8
    //   760: aload 7
    //   762: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   765: ifeq +17 -> 782
    //   768: new 216	java/io/File
    //   771: dup
    //   772: aload 8
    //   774: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   777: invokevirtual 271	java/io/File:delete	()Z
    //   780: pop
    //   781: return
    //   782: new 216	java/io/File
    //   785: dup
    //   786: aload 8
    //   788: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   791: invokevirtual 271	java/io/File:delete	()Z
    //   794: pop
    //   795: return
    //   796: astore_1
    //   797: aload 6
    //   799: astore_2
    //   800: aload_2
    //   801: ifnull +7 -> 808
    //   804: aload_2
    //   805: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   808: aload 8
    //   810: aload 7
    //   812: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   815: ifne +26 -> 841
    //   818: aload 8
    //   820: aload 7
    //   822: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   825: ifeq +18 -> 843
    //   828: new 216	java/io/File
    //   831: dup
    //   832: aload 8
    //   834: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   837: invokevirtual 271	java/io/File:delete	()Z
    //   840: pop
    //   841: aload_1
    //   842: athrow
    //   843: new 216	java/io/File
    //   846: dup
    //   847: aload 8
    //   849: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   852: invokevirtual 271	java/io/File:delete	()Z
    //   855: pop
    //   856: goto -15 -> 841
    //   859: iload 10
    //   861: iconst_3
    //   862: if_icmpne -753 -> 109
    //   865: new 175	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   872: aload 7
    //   874: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc -47
    //   879: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: astore 6
    //   887: aload 7
    //   889: aload 6
    //   891: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   894: pop
    //   895: new 216	java/io/File
    //   898: dup
    //   899: aload 6
    //   901: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   904: astore_1
    //   905: new 216	java/io/File
    //   908: dup
    //   909: aload 8
    //   911: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   914: astore 8
    //   916: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   919: ifeq +43 -> 962
    //   922: ldc -32
    //   924: iconst_4
    //   925: new 175	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 281
    //   935: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload 8
    //   940: invokevirtual 229	java/io/File:length	()J
    //   943: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   946: ldc -22
    //   948: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload 7
    //   953: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload_1
    //   963: invokevirtual 240	java/io/File:exists	()Z
    //   966: ifeq -857 -> 109
    //   969: aload 8
    //   971: invokevirtual 240	java/io/File:exists	()Z
    //   974: ifeq -865 -> 109
    //   977: new 242	java/io/RandomAccessFile
    //   980: dup
    //   981: aload_1
    //   982: ldc -12
    //   984: invokespecial 247	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   987: astore_1
    //   988: aload_1
    //   989: aload_0
    //   990: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   993: getfield 184	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   996: i2l
    //   997: invokevirtual 251	java/io/RandomAccessFile:seek	(J)V
    //   1000: new 253	java/io/FileInputStream
    //   1003: dup
    //   1004: aload 8
    //   1006: invokespecial 256	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1009: astore_2
    //   1010: sipush 1024
    //   1013: newarray <illegal type>
    //   1015: astore_3
    //   1016: aload_2
    //   1017: aload_3
    //   1018: invokevirtual 260	java/io/FileInputStream:read	([B)I
    //   1021: istore 10
    //   1023: iload 10
    //   1025: ifle +71 -> 1096
    //   1028: aload_1
    //   1029: aload_3
    //   1030: iconst_0
    //   1031: iload 10
    //   1033: invokevirtual 264	java/io/RandomAccessFile:write	([BII)V
    //   1036: goto -20 -> 1016
    //   1039: astore_3
    //   1040: aload_1
    //   1041: ifnull +7 -> 1048
    //   1044: aload_1
    //   1045: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   1048: aload_2
    //   1049: ifnull +7 -> 1056
    //   1052: aload_2
    //   1053: invokevirtual 268	java/io/FileInputStream:close	()V
    //   1056: aload 8
    //   1058: invokevirtual 271	java/io/File:delete	()Z
    //   1061: pop
    //   1062: aload 6
    //   1064: aload 7
    //   1066: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1069: ifne -960 -> 109
    //   1072: aload 6
    //   1074: aload 7
    //   1076: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1079: ifeq +93 -> 1172
    //   1082: new 216	java/io/File
    //   1085: dup
    //   1086: aload 6
    //   1088: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1091: invokevirtual 271	java/io/File:delete	()Z
    //   1094: pop
    //   1095: return
    //   1096: aload_1
    //   1097: aload 9
    //   1099: invokevirtual 279	java/io/RandomAccessFile:write	([B)V
    //   1102: aload_1
    //   1103: ifnull +7 -> 1110
    //   1106: aload_1
    //   1107: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   1110: aload_2
    //   1111: ifnull +7 -> 1118
    //   1114: aload_2
    //   1115: invokevirtual 268	java/io/FileInputStream:close	()V
    //   1118: aload 8
    //   1120: invokevirtual 271	java/io/File:delete	()Z
    //   1123: pop
    //   1124: aload 6
    //   1126: aload 7
    //   1128: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1131: ifne -1022 -> 109
    //   1134: aload 6
    //   1136: aload 7
    //   1138: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1141: ifeq +17 -> 1158
    //   1144: new 216	java/io/File
    //   1147: dup
    //   1148: aload 6
    //   1150: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1153: invokevirtual 271	java/io/File:delete	()Z
    //   1156: pop
    //   1157: return
    //   1158: new 216	java/io/File
    //   1161: dup
    //   1162: aload 6
    //   1164: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1167: invokevirtual 271	java/io/File:delete	()Z
    //   1170: pop
    //   1171: return
    //   1172: new 216	java/io/File
    //   1175: dup
    //   1176: aload 6
    //   1178: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1181: invokevirtual 271	java/io/File:delete	()Z
    //   1184: pop
    //   1185: return
    //   1186: astore_2
    //   1187: aconst_null
    //   1188: astore_1
    //   1189: aload 5
    //   1191: astore_3
    //   1192: aload_1
    //   1193: ifnull +7 -> 1200
    //   1196: aload_1
    //   1197: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   1200: aload_3
    //   1201: ifnull +7 -> 1208
    //   1204: aload_3
    //   1205: invokevirtual 268	java/io/FileInputStream:close	()V
    //   1208: aload 8
    //   1210: invokevirtual 271	java/io/File:delete	()Z
    //   1213: pop
    //   1214: aload 6
    //   1216: aload 7
    //   1218: invokestatic 273	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1221: ifne +26 -> 1247
    //   1224: aload 6
    //   1226: aload 7
    //   1228: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1231: ifeq +18 -> 1249
    //   1234: new 216	java/io/File
    //   1237: dup
    //   1238: aload 6
    //   1240: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1243: invokevirtual 271	java/io/File:delete	()Z
    //   1246: pop
    //   1247: aload_2
    //   1248: athrow
    //   1249: new 216	java/io/File
    //   1252: dup
    //   1253: aload 6
    //   1255: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   1258: invokevirtual 271	java/io/File:delete	()Z
    //   1261: pop
    //   1262: goto -15 -> 1247
    //   1265: astore_2
    //   1266: aload 5
    //   1268: astore_3
    //   1269: goto -77 -> 1192
    //   1272: astore 4
    //   1274: aload_2
    //   1275: astore_3
    //   1276: aload 4
    //   1278: astore_2
    //   1279: goto -87 -> 1192
    //   1282: astore_1
    //   1283: aconst_null
    //   1284: astore_1
    //   1285: aload_3
    //   1286: astore_2
    //   1287: goto -247 -> 1040
    //   1290: astore_2
    //   1291: aload_3
    //   1292: astore_2
    //   1293: goto -253 -> 1040
    //   1296: astore_1
    //   1297: goto -497 -> 800
    //   1300: astore_2
    //   1301: aload 4
    //   1303: astore_3
    //   1304: goto -752 -> 552
    //   1307: astore_2
    //   1308: goto -756 -> 552
    //   1311: astore_1
    //   1312: aconst_null
    //   1313: astore_1
    //   1314: goto -908 -> 406
    //   1317: astore_2
    //   1318: aconst_null
    //   1319: astore_3
    //   1320: aload_1
    //   1321: astore_2
    //   1322: aload_3
    //   1323: astore_1
    //   1324: goto -918 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1327	0	this	BasePicDownloadProcessor
    //   0	1327	1	paramNetResp	NetResp
    //   12	380	2	arrayOfByte1	byte[]
    //   401	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   403	8	2	localNetResp1	NetResp
    //   546	62	2	localObject1	Object
    //   650	465	2	localObject2	Object
    //   1186	62	2	localObject3	Object
    //   1265	10	2	localObject4	Object
    //   1278	9	2	localObject5	Object
    //   1290	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1292	1	2	localObject6	Object
    //   1300	1	2	localObject7	Object
    //   1307	1	2	localObject8	Object
    //   1317	1	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   1321	1	2	localNetResp2	NetResp
    //   7	1023	3	localObject9	Object
    //   1039	1	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   1191	132	3	localObject10	Object
    //   1	549	4	localObject11	Object
    //   1272	30	4	localObject12	Object
    //   9	1258	5	str1	String
    //   4	1250	6	localObject13	Object
    //   100	1127	7	str2	String
    //   91	1118	8	localObject14	Object
    //   16	1082	9	arrayOfByte2	byte[]
    //   220	812	10	m	int
    // Exception table:
    //   from	to	target	type
    //   372	378	401	java/io/FileNotFoundException
    //   378	385	401	java/io/FileNotFoundException
    //   390	398	401	java/io/FileNotFoundException
    //   339	350	546	finally
    //   715	726	796	finally
    //   1010	1016	1039	java/io/FileNotFoundException
    //   1016	1023	1039	java/io/FileNotFoundException
    //   1028	1036	1039	java/io/FileNotFoundException
    //   1096	1102	1039	java/io/FileNotFoundException
    //   977	988	1186	finally
    //   988	1010	1265	finally
    //   1010	1016	1272	finally
    //   1016	1023	1272	finally
    //   1028	1036	1272	finally
    //   1096	1102	1272	finally
    //   977	988	1282	java/io/FileNotFoundException
    //   988	1010	1290	java/io/FileNotFoundException
    //   726	740	1296	finally
    //   350	372	1300	finally
    //   372	378	1307	finally
    //   378	385	1307	finally
    //   390	398	1307	finally
    //   339	350	1311	java/io/FileNotFoundException
    //   350	372	1317	java/io/FileNotFoundException
  }
  
  int a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.i < 0) {}
    do
    {
      return 1;
      if (paramTransferRequest.i > 0)
      {
        if (paramTransferRequest.j > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramTransferRequest.j <= 0);
    return 2;
  }
  
  public String a(String paramString)
  {
    String str2 = b(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.f) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, PkgTools.b(localCryptor.encrypt(str1.getBytes(), this.jdField_b_of_type_ArrayOfByte)));
      }
    }
    this.f = false;
    return paramString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == 0)
    {
      str = "&rf=aio";
      str = "cldver=6.5.5.2880" + str;
      paramInt = paramString.indexOf("?");
      if (paramInt <= 0) {
        break label219;
      }
      if (paramString.length() != paramInt + 1) {
        break label136;
      }
      paramString = paramString.substring(0, paramInt + 1) + str;
    }
    for (;;)
    {
      return paramString + "&msgTime=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g != 1) {
        break;
      }
      str = "&rf=naio";
      break;
      label136:
      paramInt = paramString.indexOf("#", paramInt);
      if (paramInt > -1)
      {
        paramString = paramString.substring(0, paramInt) + "&" + str + paramString.substring(paramInt);
      }
      else
      {
        paramString = paramString + "&" + str;
        continue;
        label219:
        paramString = paramString + "?" + str;
      }
    }
  }
  
  public void a(HttpNetReq paramHttpNetReq, String paramString)
  {
    if (this.g)
    {
      paramHttpNetReq.jdField_a_of_type_JavaLangString = a(paramString);
      if (!paramString.equals(paramHttpNetReq.jdField_a_of_type_JavaLangString))
      {
        paramHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "ST=" + PkgTools.b(this.jdField_a_of_type_ArrayOfByte));
        if (this.f)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.jdField_b_of_type_ArrayOfByte);
          localPicCryptor.a = paramHttpNetReq;
          paramHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder = localPicCryptor;
          paramHttpNetReq.jdField_c_of_type_JavaLangString = (paramHttpNetReq.jdField_b_of_type_JavaLangString + "." + MD5.toMD5(RichMediaUtil.a(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.h) && (!this.f))
      {
        paramHttpNetReq.jdField_c_of_type_JavaLangString = (paramHttpNetReq.jdField_b_of_type_JavaLangString + "." + MD5.toMD5(RichMediaUtil.a(paramString, false)) + ".tmp");
        paramHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
        new StringBuilder().append(paramString).append("&rollback=1").toString();
      }
      return;
      this.f = false;
    }
  }
  
  /* Error */
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 409
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 11
    //   11: iload 11
    //   13: aload_0
    //   14: getfield 413	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:aI	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 11
    //   23: putfield 413	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:aI	I
    //   26: aload_0
    //   27: getfield 415	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   30: getfield 420	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 415	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   40: getfield 420	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 11
    //   45: invokeinterface 426 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 429	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 429	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   63: sipush 2002
    //   66: putfield 433	com/tencent/mobileqq/transfile/FileMsg:Z	I
    //   69: iconst_0
    //   70: istore 15
    //   72: iconst_0
    //   73: istore 16
    //   75: iconst_0
    //   76: istore 14
    //   78: aload_0
    //   79: getfield 151	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   82: astore 7
    //   84: aload 7
    //   86: getfield 435	com/tencent/mobileqq/transfile/TransferRequest:k	I
    //   89: istore 12
    //   91: iload 14
    //   93: istore 13
    //   95: aload 7
    //   97: getfield 184	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   100: ifne +248 -> 348
    //   103: iload 14
    //   105: istore 13
    //   107: iload 12
    //   109: ifle +239 -> 348
    //   112: iload 14
    //   114: istore 13
    //   116: aload 7
    //   118: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 216	java/io/File
    //   127: dup
    //   128: aload 7
    //   130: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   133: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 8
    //   138: new 216	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 142	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 10
    //   151: aload 10
    //   153: invokevirtual 229	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 14
    //   159: istore 13
    //   161: aload 8
    //   163: invokevirtual 240	java/io/File:exists	()Z
    //   166: ifne +182 -> 348
    //   169: iload 14
    //   171: istore 13
    //   173: lload_2
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +172 -> 348
    //   179: iload 14
    //   181: istore 13
    //   183: iload 12
    //   185: i2l
    //   186: lload_2
    //   187: lcmp
    //   188: ifge +160 -> 348
    //   191: new 216	java/io/File
    //   194: dup
    //   195: new 175	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   202: aload 7
    //   204: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   207: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 440
    //   213: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 9
    //   224: aconst_null
    //   225: astore 6
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 10
    //   231: aload 9
    //   233: iconst_0
    //   234: iload 12
    //   236: invokestatic 443	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 12
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 9
    //   250: invokevirtual 240	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 9
    //   258: invokevirtual 271	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 14
    //   264: istore 13
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 15
    //   272: istore 14
    //   274: aload_1
    //   275: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   278: iload 15
    //   280: istore 14
    //   282: aload 9
    //   284: aload 8
    //   286: invokestatic 446	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 16
    //   293: iconst_1
    //   294: istore 15
    //   296: iload 15
    //   298: istore 13
    //   300: iload 16
    //   302: istore 14
    //   304: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 16
    //   312: istore 14
    //   314: ldc -32
    //   316: iconst_4
    //   317: new 175	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 448
    //   327: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 7
    //   332: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   335: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 15
    //   346: istore 13
    //   348: aload_0
    //   349: getfield 451	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: invokevirtual 457	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 462 1 0
    //   362: ifeq +250 -> 612
    //   365: aload_1
    //   366: invokeinterface 466 1 0
    //   371: checkcast 468	com/tencent/mobileqq/pic/DownCallBack
    //   374: iload 11
    //   376: iload 13
    //   378: invokeinterface 471 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 242	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 9
    //   397: ldc -12
    //   399: invokespecial 247	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 251	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray <illegal type>
    //   412: dup
    //   413: iconst_0
    //   414: ldc -117
    //   416: bastore
    //   417: dup
    //   418: iconst_1
    //   419: ldc -116
    //   421: bastore
    //   422: invokevirtual 279	java/io/RandomAccessFile:write	([B)V
    //   425: goto -163 -> 262
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   433: iload 14
    //   435: istore 13
    //   437: goto -89 -> 348
    //   440: astore_1
    //   441: aload 6
    //   443: astore_1
    //   444: iload 14
    //   446: istore 13
    //   448: aload_1
    //   449: ifnull -101 -> 348
    //   452: iload 16
    //   454: istore 14
    //   456: aload_1
    //   457: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   460: iload 16
    //   462: istore 14
    //   464: aload 9
    //   466: aload 8
    //   468: invokestatic 446	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   471: pop
    //   472: iconst_1
    //   473: istore 16
    //   475: iconst_1
    //   476: istore 15
    //   478: iload 15
    //   480: istore 13
    //   482: iload 16
    //   484: istore 14
    //   486: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   489: ifeq -141 -> 348
    //   492: iload 16
    //   494: istore 14
    //   496: ldc -32
    //   498: iconst_4
    //   499: new 175	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 448
    //   509: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 7
    //   514: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   517: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 15
    //   528: istore 13
    //   530: goto -182 -> 348
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   538: iload 14
    //   540: istore 13
    //   542: goto -194 -> 348
    //   545: astore 6
    //   547: aconst_null
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_1
    //   554: invokevirtual 267	java/io/RandomAccessFile:close	()V
    //   557: aload 9
    //   559: aload 8
    //   561: invokestatic 446	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   564: pop
    //   565: invokestatic 222	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: ldc -32
    //   573: iconst_4
    //   574: new 175	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 448
    //   584: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 7
    //   589: getfield 438	com/tencent/mobileqq/transfile/TransferRequest:m	Ljava/lang/String;
    //   592: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload 6
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 472	java/io/IOException:printStackTrace	()V
    //   609: goto -8 -> 601
    //   612: aload_0
    //   613: monitorexit
    //   614: return
    //   615: astore 6
    //   617: goto -68 -> 549
    //   620: astore 6
    //   622: goto -178 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	BasePicDownloadProcessor
    //   0	625	1	paramNetReq	NetReq
    //   0	625	2	paramLong1	long
    //   0	625	4	paramLong2	long
    //   225	217	6	localObject1	Object
    //   545	57	6	localObject2	Object
    //   615	1	6	localObject3	Object
    //   620	1	6	localIOException	IOException
    //   82	506	7	localTransferRequest	TransferRequest
    //   136	424	8	localFile1	File
    //   222	336	9	localFile2	File
    //   149	81	10	localFile3	File
    //   9	366	11	m	int
    //   89	153	12	n	int
    //   93	448	13	bool1	boolean
    //   76	463	14	bool2	boolean
    //   70	457	15	bool3	boolean
    //   73	420	16	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   52	69	386	finally
    //   78	91	386	finally
    //   95	103	386	finally
    //   116	157	386	finally
    //   161	169	386	finally
    //   191	224	386	finally
    //   274	278	386	finally
    //   282	290	386	finally
    //   304	310	386	finally
    //   314	344	386	finally
    //   348	356	386	finally
    //   356	383	386	finally
    //   387	389	386	finally
    //   429	433	386	finally
    //   456	460	386	finally
    //   464	472	386	finally
    //   486	492	386	finally
    //   496	526	386	finally
    //   534	538	386	finally
    //   553	601	386	finally
    //   601	604	386	finally
    //   605	609	386	finally
    //   612	614	386	finally
    //   274	278	428	java/io/IOException
    //   282	290	428	java/io/IOException
    //   304	310	428	java/io/IOException
    //   314	344	428	java/io/IOException
    //   229	240	440	java/io/IOException
    //   248	262	440	java/io/IOException
    //   391	403	440	java/io/IOException
    //   456	460	533	java/io/IOException
    //   464	472	533	java/io/IOException
    //   486	492	533	java/io/IOException
    //   496	526	533	java/io/IOException
    //   229	240	545	finally
    //   248	262	545	finally
    //   391	403	545	finally
    //   553	601	604	java/io/IOException
    //   403	425	615	finally
    //   403	425	620	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    int m = 0;
    boolean bool2 = false;
    super.a(paramNetResp);
    Object localObject1 = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_b_of_type_Boolean).append(" isEncrypt:");
    boolean bool1;
    if ((this.f) || (this.g)) {
      bool1 = true;
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).append(bool1).append(" isRollBack:").append(this.h).append(" result:");
      if (paramNetResp.e == 0)
      {
        bool1 = true;
        label91:
        a("onHttpResp", bool1);
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)) {
          QLog.d("big_thumb", 2, "onResp" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "url=" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label441;
        }
        localObject1 = this.d;
        label200:
        if (paramNetResp.e != 0) {
          break label449;
        }
        bool1 = true;
        label210:
        a((BaseTransProcessor.StepInfo)localObject1, paramNetResp, bool1);
        this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
        }
        this.jdField_b_of_type_Long += paramNetResp.c;
        if ((paramNetResp.e == 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.e)) {}
      }
      try
      {
        b(paramNetResp);
        if (((this.g) || (this.f)) && (!a(paramNetResp)))
        {
          this.f = false;
          this.g = false;
          this.h = true;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
            this.l = ("checkPicFormat Erro, erroCode:" + paramNetResp.f + " ,erroDesc:" + paramNetResp.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString + " ,ST:" + PkgTools.b(this.jdField_a_of_type_ArrayOfByte));
          }
          if (this.jdField_b_of_type_Boolean) {
            e();
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label91;
          label441:
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
          break label200;
          label449:
          bool1 = false;
          break label210;
          f();
          continue;
          c();
          continue;
          if ((this.f) || (this.g))
          {
            this.f = false;
            this.g = false;
            this.h = true;
            if (paramNetResp.f != 56009) {
              break label794;
            }
            localObject1 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get(HttpMsg.am);
            bool1 = bool2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              bool1 = bool2;
              if (((String)localObject1).split("_").length >= 3)
              {
                Object localObject3 = ((String)localObject1).split("_");
                localObject1 = localObject3[0];
                Object localObject2 = localObject3[1];
                localObject3 = localObject3[2];
                bool1 = bool2;
                if ("H".equals(localObject1))
                {
                  bool1 = bool2;
                  if ("400".equals(localObject2))
                  {
                    bool1 = bool2;
                    if (((String)localObject3).equals("-106"))
                    {
                      bool1 = bool2;
                      if (this.f) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            m = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
            {
              this.l = ("encryptReqError=" + bool1 + ", ResErroCode:" + paramNetResp.f + " ,erroDesc:" + paramNetResp.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString + " ,ST:" + PkgTools.b(this.jdField_a_of_type_ArrayOfByte));
              m = bool1;
            }
            if (!this.jdField_b_of_type_Boolean) {
              break label858;
            }
            this.aJ = 3;
            this.k = paramNetResp.jdField_a_of_type_JavaLangString;
            if (m == 0) {
              break label814;
            }
            a("Encrypt Retry", "decrypt fail so retry,error:" + this.l);
            f();
            break;
            label794:
            bool1 = bool2;
            if (paramNetResp.f == 9058) {
              bool1 = true;
            }
          }
          label814:
          if ((this instanceof GroupPicDownloadProcessor)) {
            FMTSrvAddrProvider.a().a().a(2);
          }
          for (;;)
          {
            e();
            break;
            if ((this instanceof C2CPicDownloadProcessor)) {
              FMTSrvAddrProvider.a().a().a(1);
            }
          }
          label858:
          if ((paramNetResp.f == 9364) && (this.aW < 3))
          {
            a("[netChg]", "failed.but net change detect.so retry");
            this.aJ = 4;
            this.k = paramNetResp.jdField_a_of_type_JavaLangString;
            this.aW += 1;
            q();
            e();
            return;
          }
          if (m != 0)
          {
            a("Encrypt Retry", "decrypt fail so retry,error:" + this.l);
            f();
            return;
          }
          b();
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return false;
  }
  
  public String b(String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  void b()
  {
    super.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = -1;
      ((TransferResult)localObject1).jdField_a_of_type_Long = this.aU;
      ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = this.bc;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    Object localObject4;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.Z = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.aU;
        localDownResult.jdField_a_of_type_JavaLangString = this.bc;
        ((DownCallBack)localObject4).a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
        break label169;
      }
    }
    finally {}
    a("notify", "start");
    label169:
    notifyAll();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
      a("notify", "end");
    }
    Object localObject3;
    if ((this.aU == 9014) || (this.aU == 9050))
    {
      localObject3 = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        localObject3 = ((ServerAddr)localObject3).jdField_a_of_type_JavaLangString;
        localObject4 = new ProbeChain();
        if (this.aU != 9014) {
          break label339;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.aU != 9014) {
          break label366;
        }
      }
    }
    label339:
    label366:
    for (int m = 64335;; m = 64334)
    {
      localObject3 = new ProbeRequest((String)localObject3, m, (ProbeItem)localObject4);
      jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
      d(2005);
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
    }
  }
  
  void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "url=" + ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = 0;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    label329:
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject5;
          Object localObject6;
          Object localObject3;
          if (QLog.isColorLevel())
          {
            QLog.e("PIC_TAG", 2, localThrowable.getMessage());
            continue;
            localObject4 = localObject5;
            if ((localObject5 instanceof MessageForStructing))
            {
              localObject6 = (MessageForStructing)localObject5;
              localObject4 = localObject5;
              if ((((MessageForStructing)localObject6).structingMsg instanceof StructMsgForImageShare))
              {
                localObject6 = ((StructMsgForImageShare)((MessageForStructing)localObject6).structingMsg).getFirstImageElement();
                localObject4 = localObject5;
                if (localObject6 != null)
                {
                  localObject4 = localObject5;
                  if (((StructMsgItemImage)localObject6).a != null)
                  {
                    localObject4 = ((StructMsgItemImage)localObject6).a;
                    continue;
                    localObject5 = (String)localObject5 + "_hd";
                    continue;
                    bool = false;
                  }
                }
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
          break label952;
        }
        a("notify", "start");
        notifyAll();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
          break label973;
        }
        a("notify", "end");
        d(2003);
        return;
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.Z = 2003;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
          if (((TransferRequest)localObject1).m != null)
          {
            localObject5 = new File(((TransferRequest)localObject1).m);
            if ((((File)localObject5).exists()) && (((File)localObject5).delete()) && (QLog.isDevelopLevel())) {
              QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((TransferRequest)localObject1).m);
            }
          }
          int m = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
          localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label935;
          }
          localObject5 = (DownCallBack)((Iterator)localObject1).next();
          localObject6 = new DownCallBack.DownResult();
          ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Int = 0;
          ((DownCallBack.DownResult)localObject6).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
          ((DownCallBack.DownResult)localObject6).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
          ((DownCallBack.DownResult)localObject6).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
          ((DownCallBack.DownResult)localObject6).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
          if (m == 2) {
            break label994;
          }
          if (m != 3) {
            break;
          }
        }
        finally {}
        ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean = bool;
        ((DownCallBack)localObject5).a((DownCallBack.DownResult)localObject6);
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
          QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + ", isPart " + ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onSuccess ");
        }
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 131075)) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (GifDrawable.isGifFile(new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h))) || (DeviceInfoUtil.d() < 240));
    localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject5 instanceof MessageForMixedMsg))
    {
      localObject3 = ((MessageForMixedMsg)localObject5).getSubMessage(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long);
      if ((localObject3 == null) || (!(localObject3 instanceof MessageForPic))) {
        break label989;
      }
      localObject3 = (MessageForPic)localObject3;
      label549:
      if (localObject3 == null) {
        break label992;
      }
      if (((MessageForPic)localObject3).fileSizeFlag != 1) {
        break label1000;
      }
    }
    label905:
    label935:
    label952:
    label973:
    label983:
    label989:
    label992:
    label994:
    label1000:
    for (boolean bool = true;; bool = false)
    {
      URL localURL;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == URLDrawableHelper.a("chatimg", bool))
      {
        localObject6 = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, 0);
        localURL = URLDrawableHelper.a((PicUiInterface)localObject3, 65537);
        ((CompressInfo)localObject6).f = true;
        localObject5 = AbsDownloader.d(localURL.toString());
        if (!((String)localObject5).endsWith("_hd"))
        {
          if (!((String)localObject5).endsWith("_big400")) {
            break label905;
          }
          ((String)localObject5).replace("_big400", "_hd");
          ((CompressInfo)localObject6).e = ((String)localObject5);
          CompressOperator.b((CompressInfo)localObject6);
          if (((CompressInfo)localObject6).e != null)
          {
            localObject5 = new File((String)localObject5);
            if (!((CompressInfo)localObject6).e.equals(((CompressInfo)localObject6).jdField_c_of_type_JavaLangString)) {
              break label983;
            }
          }
        }
      }
      for (bool = FileUtil.a(new File(((CompressInfo)localObject6).jdField_c_of_type_JavaLangString), (File)localObject5);; bool = true)
      {
        if ((bool) && (BaseApplicationImpl.a.get(localURL.toString()) != null))
        {
          BaseApplicationImpl.a.remove(localURL.toString());
          localObject5 = URLDrawable.getDrawable(localURL);
          if (localObject5 != null) {
            ((URLDrawable)localObject5).downloadImediatly(true);
          }
        }
        if (((!HotChatHelper.a((MessageRecord)localObject3)) && (!FlashPicHelper.a((MessageRecord)localObject3))) || (TextUtils.isEmpty(((MessageForPic)localObject3).md5))) {
          break;
        }
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "_fp";
        DESUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (String)localObject5, ((MessageForPic)localObject3).md5);
        break;
      }
      Object localObject4 = null;
      break label549;
      break;
      bool = true;
      break label329;
    }
  }
  
  void e() {}
  
  void f() {}
  
  public void g()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    this.jdField_b_of_type_ArrayOfByte = ((TicketManager)localObject).getStkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    this.jdField_a_of_type_ArrayOfByte = ((TicketManager)localObject).getSt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = FMTSrvAddrProvider.a().a();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0) && (this.jdField_b_of_type_ArrayOfByte.length > 0) && (localDownloadEncryptConf != null))
    {
      this.g = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.f = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label170;
      }
    }
    label170:
    for (localObject = "key or switch can't get!";; localObject = "STKey:" + MD5.toMD5(this.jdField_b_of_type_ArrayOfByte))
    {
      a("ticketInit", (String)localObject);
      if ((!a(localDownloadEncryptConf)) || (!c))
      {
        this.f = false;
        this.g = false;
      }
      return;
      this.f = false;
      this.g = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\BasePicDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */