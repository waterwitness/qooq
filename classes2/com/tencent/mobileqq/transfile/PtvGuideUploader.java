package com.tencent.mobileqq.transfile;

import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PtvGuideUploader
{
  public static final String a = "PtvGuideUploader";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private PtvGuideUploader.IPtvGuidUpCallback jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader$IPtvGuidUpCallback;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private String e;
  private String f;
  private String g;
  
  public PtvGuideUploader(AppInterface paramAppInterface, PtvGuideUploader.IPtvGuidUpCallback paramIPtvGuidUpCallback, String paramString1, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader$IPtvGuidUpCallback = paramIPtvGuidUpCallback;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
  }
  
  private void a(boolean paramBoolean)
  {
    long l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
    this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_c_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.jdField_a_of_type_Boolean));
    if (paramBoolean) {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", true, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    while (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_d_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.g);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "PtvGuideUpload", false, l, this.jdField_b_of_type_Long + this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_2
    //   14: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 8
    //   22: iconst_2
    //   23: ldc -52
    //   25: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: invokestatic 212	android/os/SystemClock:uptimeMillis	()J
    //   32: putfield 70	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_Long	J
    //   35: aload_0
    //   36: getfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   39: ifnonnull +76 -> 115
    //   42: aload_0
    //   43: new 216	java/io/RandomAccessFile
    //   46: dup
    //   47: aload_0
    //   48: getfield 46	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: ldc -38
    //   53: invokespecial 221	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: putfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   59: aload_0
    //   60: getfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   63: ifnonnull +52 -> 115
    //   66: aload_0
    //   67: sipush 9303
    //   70: putfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   73: aload_0
    //   74: ldc -33
    //   76: putfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 42	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader$IPtvGuidUpCallback	Lcom/tencent/mobileqq/transfile/PtvGuideUploader$IPtvGuidUpCallback;
    //   83: aload_0
    //   84: getfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   87: aload_0
    //   88: getfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   91: invokeinterface 228 3 0
    //   96: aload_0
    //   97: iconst_0
    //   98: invokespecial 85	com/tencent/mobileqq/transfile/PtvGuideUploader:a	(Z)V
    //   101: return
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 231	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   112: goto -53 -> 59
    //   115: aload_0
    //   116: getfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   119: ifnonnull +76 -> 195
    //   122: aload_0
    //   123: new 216	java/io/RandomAccessFile
    //   126: dup
    //   127: aload_0
    //   128: getfield 44	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   131: ldc -38
    //   133: invokespecial 221	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: putfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   139: aload_0
    //   140: getfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   143: ifnonnull +52 -> 195
    //   146: aload_0
    //   147: sipush 9303
    //   150: putfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   153: aload_0
    //   154: ldc -21
    //   156: putfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   159: aload_0
    //   160: getfield 42	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader$IPtvGuidUpCallback	Lcom/tencent/mobileqq/transfile/PtvGuideUploader$IPtvGuidUpCallback;
    //   163: aload_0
    //   164: getfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   167: aload_0
    //   168: getfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   171: invokeinterface 228 3 0
    //   176: aload_0
    //   177: iconst_0
    //   178: invokespecial 85	com/tencent/mobileqq/transfile/PtvGuideUploader:a	(Z)V
    //   181: return
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 231	java/io/FileNotFoundException:printStackTrace	()V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   192: goto -53 -> 139
    //   195: aload_0
    //   196: getfield 50	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ArrayOfByte	[B
    //   199: arraylength
    //   200: aload_0
    //   201: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   204: arraylength
    //   205: iadd
    //   206: newarray <illegal type>
    //   208: astore_1
    //   209: aload_0
    //   210: getfield 50	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ArrayOfByte	[B
    //   213: iconst_0
    //   214: aload_1
    //   215: iconst_0
    //   216: aload_0
    //   217: getfield 50	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ArrayOfByte	[B
    //   220: arraylength
    //   221: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   224: aload_0
    //   225: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   228: iconst_0
    //   229: aload_1
    //   230: aload_0
    //   231: getfield 50	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ArrayOfByte	[B
    //   234: arraylength
    //   235: aload_0
    //   236: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   239: arraylength
    //   240: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   243: new 154	java/lang/StringBuilder
    //   246: dup
    //   247: invokestatic 242	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   250: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_1
    //   254: invokestatic 121	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   257: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc -9
    //   262: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore 7
    //   270: aload_0
    //   271: getfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   274: invokevirtual 253	java/io/RandomAccessFile:length	()J
    //   277: l2i
    //   278: newarray <illegal type>
    //   280: astore_1
    //   281: aload_0
    //   282: getfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   285: invokevirtual 253	java/io/RandomAccessFile:length	()J
    //   288: l2i
    //   289: newarray <illegal type>
    //   291: astore_3
    //   292: aload_0
    //   293: getfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   296: invokevirtual 253	java/io/RandomAccessFile:length	()J
    //   299: aload_0
    //   300: getfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   303: invokevirtual 253	java/io/RandomAccessFile:length	()J
    //   306: ladd
    //   307: l2i
    //   308: newarray <illegal type>
    //   310: astore 8
    //   312: aload_0
    //   313: getfield 214	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   316: aload_1
    //   317: invokevirtual 257	java/io/RandomAccessFile:read	([B)I
    //   320: pop
    //   321: aload_0
    //   322: getfield 233	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   325: aload_3
    //   326: invokevirtual 257	java/io/RandomAccessFile:read	([B)I
    //   329: pop
    //   330: aload_1
    //   331: iconst_0
    //   332: aload 8
    //   334: iconst_0
    //   335: aload_1
    //   336: arraylength
    //   337: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   340: aload_3
    //   341: iconst_0
    //   342: aload 8
    //   344: aload_1
    //   345: arraylength
    //   346: aload_3
    //   347: arraylength
    //   348: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   351: new 259	java/io/File
    //   354: dup
    //   355: aload 7
    //   357: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: invokevirtual 263	java/io/File:delete	()Z
    //   363: pop
    //   364: new 259	java/io/File
    //   367: dup
    //   368: aload 7
    //   370: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 266	java/io/File:exists	()Z
    //   378: istore 10
    //   380: iload 10
    //   382: ifne +8 -> 390
    //   385: aload_1
    //   386: invokevirtual 269	java/io/File:createNewFile	()Z
    //   389: pop
    //   390: new 271	java/io/FileOutputStream
    //   393: dup
    //   394: aload_1
    //   395: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   398: astore_1
    //   399: new 276	java/io/BufferedOutputStream
    //   402: dup
    //   403: aload_1
    //   404: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   407: astore_3
    //   408: aload_3
    //   409: aload 8
    //   411: invokevirtual 283	java/io/BufferedOutputStream:write	([B)V
    //   414: aload_3
    //   415: ifnull +7 -> 422
    //   418: aload_3
    //   419: invokevirtual 286	java/io/BufferedOutputStream:close	()V
    //   422: aload_1
    //   423: ifnull +7 -> 430
    //   426: aload_1
    //   427: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   430: new 289	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   433: dup
    //   434: invokespecial 290	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   437: astore_1
    //   438: aload_1
    //   439: iconst_1
    //   440: invokevirtual 293	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   443: aload_1
    //   444: getfield 297	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   447: aload_0
    //   448: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   451: invokestatic 303	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   454: invokevirtual 309	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   457: aload_1
    //   458: getfield 312	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   461: ldc2_w 313
    //   464: invokevirtual 309	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   467: aload_1
    //   468: getfield 318	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   471: iconst_1
    //   472: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   475: aload_1
    //   476: getfield 326	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   479: iconst_2
    //   480: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   483: aload_1
    //   484: getfield 329	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   487: lconst_0
    //   488: invokevirtual 309	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   491: aload_1
    //   492: getfield 332	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: iconst_0
    //   496: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   499: aload_1
    //   500: getfield 335	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   503: iconst_2
    //   504: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   507: new 337	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   510: dup
    //   511: invokespecial 338	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   514: astore_2
    //   515: new 259	java/io/File
    //   518: dup
    //   519: aload_0
    //   520: getfield 44	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   523: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   526: astore_3
    //   527: aload_3
    //   528: invokevirtual 341	java/io/File:getName	()Ljava/lang/String;
    //   531: astore 4
    //   533: aload_2
    //   534: getfield 345	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload 4
    //   539: invokevirtual 349	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   542: aload_2
    //   543: getfield 353	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   546: aload_0
    //   547: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   550: invokestatic 359	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   553: invokevirtual 364	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   556: aload_2
    //   557: getfield 367	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   560: aload_0
    //   561: getfield 50	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ArrayOfByte	[B
    //   564: invokestatic 359	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   567: invokevirtual 364	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   570: aload_2
    //   571: getfield 370	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   574: aload_3
    //   575: invokevirtual 371	java/io/File:length	()J
    //   578: invokevirtual 309	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   581: aload_0
    //   582: aload_3
    //   583: invokevirtual 371	java/io/File:length	()J
    //   586: putfield 103	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_Long	J
    //   589: aload_2
    //   590: getfield 374	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   593: aload_0
    //   594: getfield 54	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_Int	I
    //   597: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   600: aload_2
    //   601: getfield 377	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   604: aload_0
    //   605: getfield 52	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_Int	I
    //   608: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   611: aload 4
    //   613: aload 4
    //   615: ldc_w 379
    //   618: invokevirtual 383	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   621: iconst_1
    //   622: iadd
    //   623: invokevirtual 386	java/lang/String:substring	(I)Ljava/lang/String;
    //   626: astore_3
    //   627: ldc_w 388
    //   630: aload_3
    //   631: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +476 -> 1110
    //   637: iconst_2
    //   638: istore 9
    //   640: aload_2
    //   641: getfield 395	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   644: iload 9
    //   646: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   649: aload_2
    //   650: getfield 398	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   653: aload_0
    //   654: getfield 56	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_Int	I
    //   657: invokevirtual 323	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   660: new 259	java/io/File
    //   663: dup
    //   664: aload_0
    //   665: getfield 46	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   668: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   671: astore_3
    //   672: aload_2
    //   673: getfield 401	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   676: aload_3
    //   677: invokevirtual 371	java/io/File:length	()J
    //   680: invokevirtual 309	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   683: aload_0
    //   684: aload_3
    //   685: invokevirtual 371	java/io/File:length	()J
    //   688: putfield 113	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_Long	J
    //   691: aload_1
    //   692: getfield 405	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   695: aload_2
    //   696: invokevirtual 408	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   699: aload_1
    //   700: invokevirtual 412	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   703: astore_1
    //   704: ldc_w 414
    //   707: monitorenter
    //   708: aload_0
    //   709: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   712: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   715: invokevirtual 421	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   718: ifnull +45 -> 763
    //   721: aload_0
    //   722: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   725: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   728: invokevirtual 421	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   731: arraylength
    //   732: istore 9
    //   734: aload_0
    //   735: iload 9
    //   737: newarray <illegal type>
    //   739: putfield 423	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_ArrayOfByte	[B
    //   742: aload_0
    //   743: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   746: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   749: invokevirtual 421	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   752: iconst_0
    //   753: aload_0
    //   754: getfield 423	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_ArrayOfByte	[B
    //   757: iconst_0
    //   758: iload 9
    //   760: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   763: aload_0
    //   764: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   767: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   770: invokevirtual 426	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   773: ifnull +45 -> 818
    //   776: aload_0
    //   777: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   780: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   783: invokevirtual 426	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   786: arraylength
    //   787: istore 9
    //   789: aload_0
    //   790: iload 9
    //   792: newarray <illegal type>
    //   794: putfield 428	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_ArrayOfByte	[B
    //   797: aload_0
    //   798: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   801: invokestatic 418	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   804: invokevirtual 426	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   807: iconst_0
    //   808: aload_0
    //   809: getfield 428	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_ArrayOfByte	[B
    //   812: iconst_0
    //   813: iload 9
    //   815: invokestatic 239	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   818: ldc_w 414
    //   821: monitorexit
    //   822: aload_0
    //   823: getfield 423	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_ArrayOfByte	[B
    //   826: ifnull +26 -> 852
    //   829: aload_0
    //   830: getfield 423	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_ArrayOfByte	[B
    //   833: arraylength
    //   834: ifeq +18 -> 852
    //   837: aload_0
    //   838: getfield 428	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_ArrayOfByte	[B
    //   841: ifnull +11 -> 852
    //   844: aload_0
    //   845: getfield 428	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_ArrayOfByte	[B
    //   848: arraylength
    //   849: ifne +428 -> 1277
    //   852: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +12 -> 867
    //   858: ldc 8
    //   860: iconst_2
    //   861: ldc_w 430
    //   864: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: aload_0
    //   868: getfield 40	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   871: aload_0
    //   872: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   875: invokestatic 438	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   878: aload_0
    //   879: sipush 9099
    //   882: putfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   885: aload_0
    //   886: ldc_w 440
    //   889: putfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   892: aload_0
    //   893: iconst_0
    //   894: invokespecial 85	com/tencent/mobileqq/transfile/PtvGuideUploader:a	(Z)V
    //   897: return
    //   898: astore_3
    //   899: aload_3
    //   900: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   903: goto -513 -> 390
    //   906: astore_3
    //   907: aconst_null
    //   908: astore_1
    //   909: aload_3
    //   910: invokevirtual 231	java/io/FileNotFoundException:printStackTrace	()V
    //   913: aload_1
    //   914: ifnull +7 -> 921
    //   917: aload_1
    //   918: invokevirtual 286	java/io/BufferedOutputStream:close	()V
    //   921: aload_2
    //   922: ifnull -492 -> 430
    //   925: aload_2
    //   926: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   929: goto -499 -> 430
    //   932: astore_1
    //   933: aload_1
    //   934: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   937: goto -507 -> 430
    //   940: astore_2
    //   941: aload_2
    //   942: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   945: goto -523 -> 422
    //   948: astore_1
    //   949: aload_1
    //   950: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   953: goto -523 -> 430
    //   956: astore_1
    //   957: aload_1
    //   958: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   961: goto -40 -> 921
    //   964: astore 5
    //   966: aconst_null
    //   967: astore_3
    //   968: aload 4
    //   970: astore_1
    //   971: aload_1
    //   972: astore_2
    //   973: aload_3
    //   974: astore 4
    //   976: aload 5
    //   978: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   981: aload_3
    //   982: ifnull +7 -> 989
    //   985: aload_3
    //   986: invokevirtual 286	java/io/BufferedOutputStream:close	()V
    //   989: aload_1
    //   990: ifnull -560 -> 430
    //   993: aload_1
    //   994: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   997: goto -567 -> 430
    //   1000: astore_1
    //   1001: aload_1
    //   1002: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1005: goto -575 -> 430
    //   1008: astore_2
    //   1009: aload_2
    //   1010: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1013: goto -24 -> 989
    //   1016: astore_2
    //   1017: aconst_null
    //   1018: astore_3
    //   1019: aload 5
    //   1021: astore_1
    //   1022: aload_2
    //   1023: astore 5
    //   1025: aload_1
    //   1026: astore_2
    //   1027: aload_3
    //   1028: astore 4
    //   1030: aload 5
    //   1032: invokevirtual 442	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1035: aload_3
    //   1036: ifnull +7 -> 1043
    //   1039: aload_3
    //   1040: invokevirtual 286	java/io/BufferedOutputStream:close	()V
    //   1043: aload_1
    //   1044: ifnull -614 -> 430
    //   1047: aload_1
    //   1048: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   1051: goto -621 -> 430
    //   1054: astore_1
    //   1055: aload_1
    //   1056: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1059: goto -629 -> 430
    //   1062: astore_2
    //   1063: aload_2
    //   1064: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1067: goto -24 -> 1043
    //   1070: astore_1
    //   1071: aconst_null
    //   1072: astore_3
    //   1073: aload 6
    //   1075: astore_2
    //   1076: aload_3
    //   1077: ifnull +7 -> 1084
    //   1080: aload_3
    //   1081: invokevirtual 286	java/io/BufferedOutputStream:close	()V
    //   1084: aload_2
    //   1085: ifnull +7 -> 1092
    //   1088: aload_2
    //   1089: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   1092: aload_1
    //   1093: athrow
    //   1094: astore_3
    //   1095: aload_3
    //   1096: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1099: goto -15 -> 1084
    //   1102: astore_2
    //   1103: aload_2
    //   1104: invokevirtual 441	java/io/IOException:printStackTrace	()V
    //   1107: goto -15 -> 1092
    //   1110: ldc_w 444
    //   1113: aload_3
    //   1114: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1117: ifeq +9 -> 1126
    //   1120: iconst_3
    //   1121: istore 9
    //   1123: goto -483 -> 640
    //   1126: ldc_w 446
    //   1129: aload_3
    //   1130: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1133: ifeq +9 -> 1142
    //   1136: iconst_4
    //   1137: istore 9
    //   1139: goto -499 -> 640
    //   1142: ldc_w 448
    //   1145: aload_3
    //   1146: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1149: ifeq +9 -> 1158
    //   1152: iconst_5
    //   1153: istore 9
    //   1155: goto -515 -> 640
    //   1158: ldc_w 450
    //   1161: aload_3
    //   1162: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1165: ifeq +10 -> 1175
    //   1168: bipush 6
    //   1170: istore 9
    //   1172: goto -532 -> 640
    //   1175: ldc_w 452
    //   1178: aload_3
    //   1179: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1182: ifeq +10 -> 1192
    //   1185: bipush 7
    //   1187: istore 9
    //   1189: goto -549 -> 640
    //   1192: ldc_w 454
    //   1195: aload_3
    //   1196: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1199: ifeq +10 -> 1209
    //   1202: bipush 8
    //   1204: istore 9
    //   1206: goto -566 -> 640
    //   1209: ldc_w 456
    //   1212: aload_3
    //   1213: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1216: ifeq +10 -> 1226
    //   1219: bipush 9
    //   1221: istore 9
    //   1223: goto -583 -> 640
    //   1226: ldc_w 458
    //   1229: aload_3
    //   1230: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1233: ifeq +10 -> 1243
    //   1236: bipush 10
    //   1238: istore 9
    //   1240: goto -600 -> 640
    //   1243: ldc_w 460
    //   1246: aload_3
    //   1247: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1250: ifne -610 -> 640
    //   1253: ldc_w 462
    //   1256: aload_3
    //   1257: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1260: ifeq +312 -> 1572
    //   1263: bipush 11
    //   1265: istore 9
    //   1267: goto -627 -> 640
    //   1270: astore_1
    //   1271: ldc_w 414
    //   1274: monitorexit
    //   1275: aload_1
    //   1276: athrow
    //   1277: new 464	com/tencent/qphone/base/util/Cryptor
    //   1280: dup
    //   1281: invokespecial 465	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   1284: aload_1
    //   1285: aload_0
    //   1286: getfield 428	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_c_of_type_ArrayOfByte	[B
    //   1289: invokevirtual 469	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   1292: astore_1
    //   1293: new 471	vbj
    //   1296: dup
    //   1297: aload_0
    //   1298: aload 7
    //   1300: invokespecial 474	vbj:<init>	(Lcom/tencent/mobileqq/transfile/PtvGuideUploader;Ljava/lang/String;)V
    //   1303: astore_2
    //   1304: aload_0
    //   1305: new 476	com/tencent/mobileqq/highway/transaction/Transaction
    //   1308: dup
    //   1309: aload_0
    //   1310: getfield 63	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1313: bipush 12
    //   1315: aload 7
    //   1317: iconst_0
    //   1318: aload_0
    //   1319: getfield 423	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_ArrayOfByte	[B
    //   1322: aload_0
    //   1323: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   1326: aload_2
    //   1327: aload_1
    //   1328: invokespecial 479	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   1331: putfield 73	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1334: aload_0
    //   1335: getfield 40	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1338: invokevirtual 482	com/tencent/common/app/AppInterface:a	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   1341: aload_0
    //   1342: getfield 73	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1345: invokevirtual 488	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   1348: istore 9
    //   1350: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1353: ifeq +89 -> 1442
    //   1356: ldc 8
    //   1358: iconst_2
    //   1359: new 154	java/lang/StringBuilder
    //   1362: dup
    //   1363: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   1366: ldc_w 490
    //   1369: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: iload 9
    //   1374: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: ldc_w 495
    //   1380: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload_0
    //   1384: getfield 73	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1387: invokevirtual 499	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   1390: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1393: ldc_w 501
    //   1396: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: aload_0
    //   1400: getfield 48	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_b_of_type_ArrayOfByte	[B
    //   1403: invokestatic 121	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1406: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: ldc_w 503
    //   1412: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload_0
    //   1416: getfield 73	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1419: getfield 506	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   1422: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: ldc_w 508
    //   1428: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: bipush 12
    //   1433: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1442: iload 9
    //   1444: ifeq -1343 -> 101
    //   1447: aload_0
    //   1448: iload 9
    //   1450: putfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   1453: aload_0
    //   1454: ldc_w 510
    //   1457: putfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   1460: aload_0
    //   1461: getfield 42	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader$IPtvGuidUpCallback	Lcom/tencent/mobileqq/transfile/PtvGuideUploader$IPtvGuidUpCallback;
    //   1464: aload_0
    //   1465: getfield 67	com/tencent/mobileqq/transfile/PtvGuideUploader:jdField_d_of_type_Int	I
    //   1468: aload_0
    //   1469: getfield 195	com/tencent/mobileqq/transfile/PtvGuideUploader:g	Ljava/lang/String;
    //   1472: invokeinterface 228 3 0
    //   1477: aload_0
    //   1478: iconst_0
    //   1479: invokespecial 85	com/tencent/mobileqq/transfile/PtvGuideUploader:a	(Z)V
    //   1482: return
    //   1483: astore 4
    //   1485: aconst_null
    //   1486: astore_3
    //   1487: aload_1
    //   1488: astore_2
    //   1489: aload 4
    //   1491: astore_1
    //   1492: goto -416 -> 1076
    //   1495: astore 4
    //   1497: aload_1
    //   1498: astore_2
    //   1499: aload 4
    //   1501: astore_1
    //   1502: goto -426 -> 1076
    //   1505: astore 4
    //   1507: aload_1
    //   1508: astore_3
    //   1509: aload 4
    //   1511: astore_1
    //   1512: goto -436 -> 1076
    //   1515: astore_1
    //   1516: aload 4
    //   1518: astore_3
    //   1519: goto -443 -> 1076
    //   1522: astore 5
    //   1524: aconst_null
    //   1525: astore_3
    //   1526: goto -501 -> 1025
    //   1529: astore 5
    //   1531: goto -506 -> 1025
    //   1534: astore 5
    //   1536: aconst_null
    //   1537: astore_3
    //   1538: goto -567 -> 971
    //   1541: astore 5
    //   1543: goto -572 -> 971
    //   1546: astore_3
    //   1547: aconst_null
    //   1548: astore 4
    //   1550: aload_1
    //   1551: astore_2
    //   1552: aload 4
    //   1554: astore_1
    //   1555: goto -646 -> 909
    //   1558: astore_2
    //   1559: aload_3
    //   1560: astore 4
    //   1562: aload_2
    //   1563: astore_3
    //   1564: aload_1
    //   1565: astore_2
    //   1566: aload 4
    //   1568: astore_1
    //   1569: goto -660 -> 909
    //   1572: iconst_m1
    //   1573: istore 9
    //   1575: goto -935 -> 640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1578	0	this	PtvGuideUploader
    //   102	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   182	2	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   208	710	1	localObject1	Object
    //   932	2	1	localIOException1	java.io.IOException
    //   948	2	1	localIOException2	java.io.IOException
    //   956	2	1	localIOException3	java.io.IOException
    //   970	24	1	localObject2	Object
    //   1000	2	1	localIOException4	java.io.IOException
    //   1021	27	1	localIOException5	java.io.IOException
    //   1054	2	1	localIOException6	java.io.IOException
    //   1070	23	1	localObject3	Object
    //   1270	15	1	arrayOfByte1	byte[]
    //   1292	220	1	localObject4	Object
    //   1515	36	1	localObject5	Object
    //   1554	15	1	localObject6	Object
    //   13	913	2	localPttShortVideoFileInfo	pttcenterservice.PttShortVideo.PttShortVideoFileInfo
    //   940	2	2	localIOException7	java.io.IOException
    //   972	1	2	localObject7	Object
    //   1008	2	2	localIOException8	java.io.IOException
    //   1016	7	2	localOutOfMemoryError1	OutOfMemoryError
    //   1026	1	2	localObject8	Object
    //   1062	2	2	localIOException9	java.io.IOException
    //   1075	14	2	localObject9	Object
    //   1102	2	2	localIOException10	java.io.IOException
    //   1303	249	2	localObject10	Object
    //   1558	5	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   1565	1	2	localObject11	Object
    //   291	394	3	localObject12	Object
    //   898	2	3	localIOException11	java.io.IOException
    //   906	4	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   967	114	3	localObject13	Object
    //   1094	163	3	localIOException12	java.io.IOException
    //   1486	52	3	localObject14	Object
    //   1546	14	3	localFileNotFoundException5	java.io.FileNotFoundException
    //   1563	1	3	localFileNotFoundException6	java.io.FileNotFoundException
    //   4	1025	4	localObject15	Object
    //   1483	7	4	localObject16	Object
    //   1495	5	4	localObject17	Object
    //   1505	12	4	localObject18	Object
    //   1548	19	4	localObject19	Object
    //   7	1	5	localObject20	Object
    //   964	56	5	localIOException13	java.io.IOException
    //   1023	8	5	localObject21	Object
    //   1522	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   1529	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   1534	1	5	localIOException14	java.io.IOException
    //   1541	1	5	localIOException15	java.io.IOException
    //   10	1064	6	localObject22	Object
    //   268	1048	7	str	String
    //   310	100	8	arrayOfByte2	byte[]
    //   1	1573	9	i	int
    //   378	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   42	59	102	java/io/FileNotFoundException
    //   122	139	182	java/io/FileNotFoundException
    //   385	390	898	java/io/IOException
    //   270	380	906	java/io/FileNotFoundException
    //   385	390	906	java/io/FileNotFoundException
    //   390	399	906	java/io/FileNotFoundException
    //   899	903	906	java/io/FileNotFoundException
    //   925	929	932	java/io/IOException
    //   418	422	940	java/io/IOException
    //   426	430	948	java/io/IOException
    //   917	921	956	java/io/IOException
    //   270	380	964	java/io/IOException
    //   390	399	964	java/io/IOException
    //   899	903	964	java/io/IOException
    //   993	997	1000	java/io/IOException
    //   985	989	1008	java/io/IOException
    //   270	380	1016	java/lang/OutOfMemoryError
    //   385	390	1016	java/lang/OutOfMemoryError
    //   390	399	1016	java/lang/OutOfMemoryError
    //   899	903	1016	java/lang/OutOfMemoryError
    //   1047	1051	1054	java/io/IOException
    //   1039	1043	1062	java/io/IOException
    //   270	380	1070	finally
    //   385	390	1070	finally
    //   390	399	1070	finally
    //   899	903	1070	finally
    //   1080	1084	1094	java/io/IOException
    //   1088	1092	1102	java/io/IOException
    //   708	763	1270	finally
    //   763	818	1270	finally
    //   818	822	1270	finally
    //   1271	1275	1270	finally
    //   399	408	1483	finally
    //   408	414	1495	finally
    //   909	913	1505	finally
    //   976	981	1515	finally
    //   1030	1035	1515	finally
    //   399	408	1522	java/lang/OutOfMemoryError
    //   408	414	1529	java/lang/OutOfMemoryError
    //   399	408	1534	java/io/IOException
    //   408	414	1541	java/io/IOException
    //   399	408	1546	java/io/FileNotFoundException
    //   408	414	1558	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\PtvGuideUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */