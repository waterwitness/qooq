package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.ims.safecheckPB.ReportItem;
import com.tencent.ims.safecheckPB.ReqMQScanRequest;
import com.tencent.ims.safecheckPB.RspMQScanReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qdv;

public class QPSafeCheckHandler
  extends BusinessHandler
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "QPSafeCheck";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int b = 1001;
  private static final int c = 1002;
  private static final int d = 1003;
  private static final int e = 1004;
  private static final int f = 1005;
  private static final int g = 1006;
  private static final int h = 1007;
  private Context jdField_a_of_type_AndroidContentContext;
  
  QPSafeCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    int i;
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 0;
    }
    while ((i & paramInt) == 0)
    {
      return false;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 8;
      continue;
      i = 16;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() == 0) || (paramString2.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = Pattern.compile(paramString1, 2).matcher(paramString2).find();
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 1);
      Object localObject2 = SecUtil.getSign(BaseApplication.getContext());
      new String();
      localObject2 = SecUtil.getSignatureHash((byte[])localObject2);
      new String();
      if (paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject2)) {
        return;
      }
    }
    catch (RuntimeException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      return;
    }
    catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
    {
      paramReqMQScanRequest.printStackTrace();
      return;
    }
    paramReqMQScanRequest = new safecheckPB.ReportItem();
    paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject1).packageName);
    paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((PackageInfo)localObject1).applicationInfo.sourceDir));
    paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
    paramRspMQScanReport.uint32_check_count.set(1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = SafeCenterPushHandler.a();
    if (QLog.isColorLevel()) {
      QLog.d("QPSafeCheck", 2, "thread num = " + i);
    }
    if (i >= 1) {
      return;
    }
    ThreadManager.a(new qdv(this, paramArrayOfByte), 5, null, false);
  }
  
  public void b(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    paramReqMQScanRequest = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    List localList = paramReqMQScanRequest.getInstalledApplications(8192);
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < localList.size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ApplicationInfo)localList.get(j)).packageName, 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      j += 1;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (true == jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Object localObject = new safecheckPB.ReqMQScanRequest();
    safecheckPB.RspMQScanReport localRspMQScanReport = new safecheckPB.RspMQScanReport();
    try
    {
      ((safecheckPB.ReqMQScanRequest)localObject).mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("QPSafeCheck", 2, "Check Item" + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_target.get() + ((safecheckPB.ReqMQScanRequest)localObject).string_check_parameters.get() + ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get());
      }
      if (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        SafeCenterPushHandler.b();
        jdField_a_of_type_Boolean = false;
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QPSafeCheck", 2, "RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      jdField_a_of_type_Boolean = false;
      paramArrayOfByte.printStackTrace();
    }
    for (;;)
    {
      if (!a(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_condition.get()))
      {
        SafeCenterPushHandler.b();
        jdField_a_of_type_Boolean = false;
        return;
        if (!((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.has()) {
          break label582;
        }
      }
      label582:
      for (int i = ((safecheckPB.ReqMQScanRequest)localObject).uint32_check_type.get();; i = 0)
      {
        localRspMQScanReport.uint32_check_uid.set(((safecheckPB.ReqMQScanRequest)localObject).uint32_check_uid.get());
        localRspMQScanReport.uint32_check_count.set(0);
        switch (i)
        {
        case 1001: 
          a((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1002: 
          b((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1007: 
          c((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1004: 
          e((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1005: 
          f((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
        case 1006: 
          d((safecheckPB.ReqMQScanRequest)localObject, localRspMQScanReport);
          break;
          i = 0;
          paramArrayOfByte = new safecheckPB.RspMQScanReport();
          if (localRspMQScanReport.uint32_check_count.get() > 48)
          {
            paramArrayOfByte.uint32_check_count.set(48);
            paramArrayOfByte.uint32_check_uid.set(localRspMQScanReport.uint32_check_uid.get());
            localObject = new ArrayList();
            j = 0;
            while (j < 48)
            {
              ((List)localObject).add(localRspMQScanReport.rpt_check_item.get(0));
              localRspMQScanReport.rpt_check_item.remove(0);
              j += 1;
            }
            paramArrayOfByte.rpt_check_item.set((List)localObject);
            j = localRspMQScanReport.uint32_check_count.get();
            localRspMQScanReport.uint32_check_count.set(j - 48);
            localObject = a("SecSafeChkSvc.MainCmd");
            ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
            b((ToServiceMsg)localObject);
          }
          for (int j = i;; j = 1)
          {
            i = j;
            if (j == 0) {
              break;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("QPSafeCheck", 2, "check uid = " + localRspMQScanReport.uint32_check_uid.get());
              QLog.d("QPSafeCheck", 2, "check count = " + localRspMQScanReport.uint32_check_count.get());
            }
            SafeCenterPushHandler.b();
            jdField_a_of_type_Boolean = false;
            return;
            paramArrayOfByte = a("SecSafeChkSvc.MainCmd");
            paramArrayOfByte.putWupBuffer(localRspMQScanReport.toByteArray());
            b(paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void c(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    int i;
    String str;
    do
    {
      try
      {
        localObject = ((PackageManager)localObject).getInstalledApplications(8192);
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label164;
          }
          if ((ApplicationInfo)((List)localObject).get(i) != null) {
            break;
          }
          i += 1;
        }
        str = ((ApplicationInfo)((List)localObject).get(i)).processName;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
    } while ((str == null) || (!a(paramReqMQScanRequest.string_check_target.get(), str)));
    paramReqMQScanRequest = new safecheckPB.ReportItem();
    paramReqMQScanRequest.string_target_packname.set(((ApplicationInfo)((List)localObject).get(i)).packageName);
    paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((ApplicationInfo)((List)localObject).get(i)).sourceDir));
    paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
    paramRspMQScanReport.uint32_check_count.set(1);
    label164:
    SafeCenterPushHandler.b();
  }
  
  /* Error */
  public void d(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 12
    //   20: aconst_null
    //   21: astore 11
    //   23: aload_0
    //   24: getfield 44	com/tencent/mobileqq/app/QPSafeCheckHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   27: invokevirtual 90	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: astore 4
    //   32: aload 4
    //   34: aload_0
    //   35: getfield 44	com/tencent/mobileqq/app/QPSafeCheckHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   38: invokevirtual 94	android/content/Context:getPackageName	()Ljava/lang/String;
    //   41: iconst_1
    //   42: invokevirtual 100	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   45: astore 13
    //   47: new 331	java/util/zip/ZipFile
    //   50: dup
    //   51: aload 13
    //   53: getfield 154	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   56: getfield 159	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   59: invokespecial 333	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   62: astore 6
    //   64: aload 11
    //   66: astore 8
    //   68: aload 10
    //   70: astore 9
    //   72: aload 5
    //   74: astore_3
    //   75: aload 6
    //   77: astore 4
    //   79: aload 12
    //   81: astore 7
    //   83: aload 6
    //   85: ldc_w 335
    //   88: invokevirtual 339	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   91: astore 14
    //   93: aload 14
    //   95: ifnonnull +83 -> 178
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 341	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 342	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: aload 6
    //   112: ifnull +8 -> 120
    //   115: aload 6
    //   117: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 131	java/lang/RuntimeException:printStackTrace	()V
    //   126: iconst_0
    //   127: ifeq +11 -> 138
    //   130: new 341	java/lang/NullPointerException
    //   133: dup
    //   134: invokespecial 342	java/lang/NullPointerException:<init>	()V
    //   137: athrow
    //   138: iconst_0
    //   139: ifeq -19 -> 120
    //   142: new 341	java/lang/NullPointerException
    //   145: dup
    //   146: invokespecial 342	java/lang/NullPointerException:<init>	()V
    //   149: athrow
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   161: goto -23 -> 138
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   169: goto -59 -> 110
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   177: return
    //   178: aload 11
    //   180: astore 8
    //   182: aload 10
    //   184: astore 9
    //   186: aload 5
    //   188: astore_3
    //   189: aload 6
    //   191: astore 4
    //   193: aload 12
    //   195: astore 7
    //   197: aload 6
    //   199: aload 14
    //   201: invokevirtual 350	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   204: astore 5
    //   206: aload 5
    //   208: ifnonnull +38 -> 246
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 353	java/io/InputStream:close	()V
    //   221: aload 6
    //   223: ifnull -103 -> 120
    //   226: aload 6
    //   228: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   231: return
    //   232: astore_1
    //   233: aload_1
    //   234: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   243: goto -22 -> 221
    //   246: aload 5
    //   248: astore 8
    //   250: aload 5
    //   252: astore 9
    //   254: aload 5
    //   256: astore_3
    //   257: aload 6
    //   259: astore 4
    //   261: aload 5
    //   263: astore 7
    //   265: sipush 8192
    //   268: newarray <illegal type>
    //   270: astore 10
    //   272: aload 5
    //   274: astore 8
    //   276: aload 5
    //   278: astore 9
    //   280: aload 5
    //   282: astore_3
    //   283: aload 6
    //   285: astore 4
    //   287: aload 5
    //   289: astore 7
    //   291: ldc_w 355
    //   294: invokestatic 361	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   297: astore 11
    //   299: aload 5
    //   301: astore 8
    //   303: aload 5
    //   305: astore 9
    //   307: aload 5
    //   309: astore_3
    //   310: aload 6
    //   312: astore 4
    //   314: aload 5
    //   316: astore 7
    //   318: aload 5
    //   320: aload 10
    //   322: invokevirtual 365	java/io/InputStream:read	([B)I
    //   325: istore 15
    //   327: iload 15
    //   329: ifle +74 -> 403
    //   332: aload 5
    //   334: astore 8
    //   336: aload 5
    //   338: astore 9
    //   340: aload 5
    //   342: astore_3
    //   343: aload 6
    //   345: astore 4
    //   347: aload 5
    //   349: astore 7
    //   351: aload 11
    //   353: aload 10
    //   355: iconst_0
    //   356: iload 15
    //   358: invokevirtual 369	java/security/MessageDigest:update	([BII)V
    //   361: goto -62 -> 299
    //   364: astore_1
    //   365: aload 8
    //   367: astore_3
    //   368: aload 6
    //   370: astore 4
    //   372: aload_1
    //   373: invokevirtual 132	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   376: aload 8
    //   378: ifnull +8 -> 386
    //   381: aload 8
    //   383: invokevirtual 353	java/io/InputStream:close	()V
    //   386: aload 6
    //   388: ifnull -268 -> 120
    //   391: aload 6
    //   393: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   396: return
    //   397: astore_1
    //   398: aload_1
    //   399: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   402: return
    //   403: aload 5
    //   405: astore 8
    //   407: aload 5
    //   409: astore 9
    //   411: aload 5
    //   413: astore_3
    //   414: aload 6
    //   416: astore 4
    //   418: aload 5
    //   420: astore 7
    //   422: aload 11
    //   424: invokevirtual 372	java/security/MessageDigest:digest	()[B
    //   427: invokestatic 375	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   430: astore 10
    //   432: aload 5
    //   434: astore 8
    //   436: aload 5
    //   438: astore 9
    //   440: aload 5
    //   442: astore_3
    //   443: aload 6
    //   445: astore 4
    //   447: aload 5
    //   449: astore 7
    //   451: new 59	java/lang/String
    //   454: dup
    //   455: invokespecial 109	java/lang/String:<init>	()V
    //   458: pop
    //   459: aload 5
    //   461: astore 8
    //   463: aload 5
    //   465: astore 9
    //   467: aload 5
    //   469: astore_3
    //   470: aload 6
    //   472: astore 4
    //   474: aload 5
    //   476: astore 7
    //   478: aload_1
    //   479: getfield 119	com/tencent/ims/safecheckPB$ReqMQScanRequest:string_check_target	Lcom/tencent/mobileqq/pb/PBStringField;
    //   482: invokevirtual 124	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   485: aload 10
    //   487: invokevirtual 128	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   490: istore 16
    //   492: iload 16
    //   494: ifeq +129 -> 623
    //   497: aload 5
    //   499: ifnull +23 -> 522
    //   502: aload 5
    //   504: astore 8
    //   506: aload 5
    //   508: astore 9
    //   510: aload 5
    //   512: astore_3
    //   513: aload 6
    //   515: astore 4
    //   517: aload 5
    //   519: invokevirtual 353	java/io/InputStream:close	()V
    //   522: aload 5
    //   524: ifnull +8 -> 532
    //   527: aload 5
    //   529: invokevirtual 353	java/io/InputStream:close	()V
    //   532: aload 6
    //   534: ifnull -414 -> 120
    //   537: aload 6
    //   539: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   542: return
    //   543: astore_1
    //   544: aload_1
    //   545: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   548: return
    //   549: astore_1
    //   550: aload 5
    //   552: astore 8
    //   554: aload 5
    //   556: astore 9
    //   558: aload 5
    //   560: astore_3
    //   561: aload 6
    //   563: astore 4
    //   565: aload 5
    //   567: astore 7
    //   569: aload_1
    //   570: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   573: goto -51 -> 522
    //   576: astore_1
    //   577: aload 9
    //   579: astore_3
    //   580: aload 6
    //   582: astore 4
    //   584: aload_1
    //   585: invokevirtual 376	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   588: aload 9
    //   590: ifnull +8 -> 598
    //   593: aload 9
    //   595: invokevirtual 353	java/io/InputStream:close	()V
    //   598: aload 6
    //   600: ifnull -480 -> 120
    //   603: aload 6
    //   605: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   608: return
    //   609: astore_1
    //   610: aload_1
    //   611: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   614: return
    //   615: astore_1
    //   616: aload_1
    //   617: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   620: goto -88 -> 532
    //   623: aload 5
    //   625: astore 8
    //   627: aload 5
    //   629: astore 9
    //   631: aload 5
    //   633: astore_3
    //   634: aload 6
    //   636: astore 4
    //   638: aload 5
    //   640: astore 7
    //   642: aload_2
    //   643: getfield 272	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   646: aload_1
    //   647: getfield 250	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   650: invokevirtual 252	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   653: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   656: aload 5
    //   658: astore 8
    //   660: aload 5
    //   662: astore 9
    //   664: aload 5
    //   666: astore_3
    //   667: aload 6
    //   669: astore 4
    //   671: aload 5
    //   673: astore 7
    //   675: aload_2
    //   676: getfield 179	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   679: iconst_1
    //   680: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   683: aload 5
    //   685: astore 8
    //   687: aload 5
    //   689: astore 9
    //   691: aload 5
    //   693: astore_3
    //   694: aload 6
    //   696: astore 4
    //   698: aload 5
    //   700: astore 7
    //   702: new 134	com/tencent/ims/safecheckPB$ReportItem
    //   705: dup
    //   706: invokespecial 135	com/tencent/ims/safecheckPB$ReportItem:<init>	()V
    //   709: astore_1
    //   710: aload 5
    //   712: astore 8
    //   714: aload 5
    //   716: astore 9
    //   718: aload 5
    //   720: astore_3
    //   721: aload 6
    //   723: astore 4
    //   725: aload 5
    //   727: astore 7
    //   729: aload_1
    //   730: getfield 138	com/tencent/ims/safecheckPB$ReportItem:string_target_packname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   733: aload 13
    //   735: getfield 143	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   738: invokevirtual 147	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   741: aload 5
    //   743: astore 8
    //   745: aload 5
    //   747: astore 9
    //   749: aload 5
    //   751: astore_3
    //   752: aload 6
    //   754: astore 4
    //   756: aload 5
    //   758: astore 7
    //   760: aload_1
    //   761: getfield 150	com/tencent/ims/safecheckPB$ReportItem:string_target_md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   764: aload 10
    //   766: invokevirtual 147	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   769: aload 5
    //   771: astore 8
    //   773: aload 5
    //   775: astore 9
    //   777: aload 5
    //   779: astore_3
    //   780: aload 6
    //   782: astore 4
    //   784: aload 5
    //   786: astore 7
    //   788: aload_2
    //   789: getfield 169	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   792: aload_1
    //   793: invokevirtual 175	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   796: aload 5
    //   798: ifnull +8 -> 806
    //   801: aload 5
    //   803: invokevirtual 353	java/io/InputStream:close	()V
    //   806: aload 6
    //   808: ifnull -688 -> 120
    //   811: aload 6
    //   813: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   816: return
    //   817: astore_1
    //   818: aload_1
    //   819: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   822: return
    //   823: astore_1
    //   824: aload_1
    //   825: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   828: goto -22 -> 806
    //   831: astore_1
    //   832: aload_1
    //   833: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   836: goto -450 -> 386
    //   839: astore_1
    //   840: aload_1
    //   841: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   844: goto -246 -> 598
    //   847: astore_1
    //   848: aconst_null
    //   849: astore 6
    //   851: aload 7
    //   853: astore_3
    //   854: aload 6
    //   856: astore 4
    //   858: aload_1
    //   859: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   862: aload 7
    //   864: ifnull +8 -> 872
    //   867: aload 7
    //   869: invokevirtual 353	java/io/InputStream:close	()V
    //   872: aload 6
    //   874: ifnull -754 -> 120
    //   877: aload 6
    //   879: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   882: return
    //   883: astore_1
    //   884: aload_1
    //   885: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   888: return
    //   889: astore_1
    //   890: aload_1
    //   891: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   894: goto -22 -> 872
    //   897: astore_1
    //   898: aconst_null
    //   899: astore 4
    //   901: aload_3
    //   902: ifnull +7 -> 909
    //   905: aload_3
    //   906: invokevirtual 353	java/io/InputStream:close	()V
    //   909: aload 4
    //   911: ifnull +8 -> 919
    //   914: aload 4
    //   916: invokevirtual 345	java/util/zip/ZipFile:close	()V
    //   919: aload_1
    //   920: athrow
    //   921: astore_2
    //   922: aload_2
    //   923: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   926: goto -17 -> 909
    //   929: astore_2
    //   930: aload_2
    //   931: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   934: goto -15 -> 919
    //   937: astore_1
    //   938: goto -37 -> 901
    //   941: astore_1
    //   942: goto -91 -> 851
    //   945: astore_1
    //   946: aconst_null
    //   947: astore 6
    //   949: goto -372 -> 577
    //   952: astore_1
    //   953: aconst_null
    //   954: astore 6
    //   956: goto -591 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	959	0	this	QPSafeCheckHandler
    //   0	959	1	paramReqMQScanRequest	safecheckPB.ReqMQScanRequest
    //   0	959	2	paramRspMQScanReport	safecheckPB.RspMQScanReport
    //   13	893	3	localObject1	Object
    //   30	885	4	localObject2	Object
    //   15	787	5	localInputStream	java.io.InputStream
    //   62	893	6	localZipFile	java.util.zip.ZipFile
    //   10	858	7	localObject3	Object
    //   1	771	8	localObject4	Object
    //   7	769	9	localObject5	Object
    //   4	761	10	localObject6	Object
    //   21	402	11	localMessageDigest	java.security.MessageDigest
    //   18	176	12	localObject7	Object
    //   45	689	13	localPackageInfo	PackageInfo
    //   91	109	14	localZipEntry	java.util.zip.ZipEntry
    //   325	32	15	i	int
    //   490	3	16	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   32	47	121	java/lang/RuntimeException
    //   142	150	150	java/io/IOException
    //   130	138	156	java/io/IOException
    //   102	110	164	java/io/IOException
    //   115	120	172	java/io/IOException
    //   226	231	232	java/io/IOException
    //   216	221	238	java/io/IOException
    //   83	93	364	android/content/pm/PackageManager$NameNotFoundException
    //   197	206	364	android/content/pm/PackageManager$NameNotFoundException
    //   265	272	364	android/content/pm/PackageManager$NameNotFoundException
    //   291	299	364	android/content/pm/PackageManager$NameNotFoundException
    //   318	327	364	android/content/pm/PackageManager$NameNotFoundException
    //   351	361	364	android/content/pm/PackageManager$NameNotFoundException
    //   422	432	364	android/content/pm/PackageManager$NameNotFoundException
    //   451	459	364	android/content/pm/PackageManager$NameNotFoundException
    //   478	492	364	android/content/pm/PackageManager$NameNotFoundException
    //   517	522	364	android/content/pm/PackageManager$NameNotFoundException
    //   569	573	364	android/content/pm/PackageManager$NameNotFoundException
    //   642	656	364	android/content/pm/PackageManager$NameNotFoundException
    //   675	683	364	android/content/pm/PackageManager$NameNotFoundException
    //   702	710	364	android/content/pm/PackageManager$NameNotFoundException
    //   729	741	364	android/content/pm/PackageManager$NameNotFoundException
    //   760	769	364	android/content/pm/PackageManager$NameNotFoundException
    //   788	796	364	android/content/pm/PackageManager$NameNotFoundException
    //   391	396	397	java/io/IOException
    //   537	542	543	java/io/IOException
    //   517	522	549	java/io/IOException
    //   83	93	576	java/security/NoSuchAlgorithmException
    //   197	206	576	java/security/NoSuchAlgorithmException
    //   265	272	576	java/security/NoSuchAlgorithmException
    //   291	299	576	java/security/NoSuchAlgorithmException
    //   318	327	576	java/security/NoSuchAlgorithmException
    //   351	361	576	java/security/NoSuchAlgorithmException
    //   422	432	576	java/security/NoSuchAlgorithmException
    //   451	459	576	java/security/NoSuchAlgorithmException
    //   478	492	576	java/security/NoSuchAlgorithmException
    //   517	522	576	java/security/NoSuchAlgorithmException
    //   569	573	576	java/security/NoSuchAlgorithmException
    //   642	656	576	java/security/NoSuchAlgorithmException
    //   675	683	576	java/security/NoSuchAlgorithmException
    //   702	710	576	java/security/NoSuchAlgorithmException
    //   729	741	576	java/security/NoSuchAlgorithmException
    //   760	769	576	java/security/NoSuchAlgorithmException
    //   788	796	576	java/security/NoSuchAlgorithmException
    //   603	608	609	java/io/IOException
    //   527	532	615	java/io/IOException
    //   811	816	817	java/io/IOException
    //   801	806	823	java/io/IOException
    //   381	386	831	java/io/IOException
    //   593	598	839	java/io/IOException
    //   32	47	847	java/io/IOException
    //   47	64	847	java/io/IOException
    //   122	126	847	java/io/IOException
    //   877	882	883	java/io/IOException
    //   867	872	889	java/io/IOException
    //   32	47	897	finally
    //   47	64	897	finally
    //   122	126	897	finally
    //   905	909	921	java/io/IOException
    //   914	919	929	java/io/IOException
    //   83	93	937	finally
    //   197	206	937	finally
    //   265	272	937	finally
    //   291	299	937	finally
    //   318	327	937	finally
    //   351	361	937	finally
    //   372	376	937	finally
    //   422	432	937	finally
    //   451	459	937	finally
    //   478	492	937	finally
    //   517	522	937	finally
    //   569	573	937	finally
    //   584	588	937	finally
    //   642	656	937	finally
    //   675	683	937	finally
    //   702	710	937	finally
    //   729	741	937	finally
    //   760	769	937	finally
    //   788	796	937	finally
    //   858	862	937	finally
    //   83	93	941	java/io/IOException
    //   197	206	941	java/io/IOException
    //   265	272	941	java/io/IOException
    //   291	299	941	java/io/IOException
    //   318	327	941	java/io/IOException
    //   351	361	941	java/io/IOException
    //   422	432	941	java/io/IOException
    //   451	459	941	java/io/IOException
    //   478	492	941	java/io/IOException
    //   569	573	941	java/io/IOException
    //   642	656	941	java/io/IOException
    //   675	683	941	java/io/IOException
    //   702	710	941	java/io/IOException
    //   729	741	941	java/io/IOException
    //   760	769	941	java/io/IOException
    //   788	796	941	java/io/IOException
    //   32	47	945	java/security/NoSuchAlgorithmException
    //   47	64	945	java/security/NoSuchAlgorithmException
    //   122	126	945	java/security/NoSuchAlgorithmException
    //   32	47	952	android/content/pm/PackageManager$NameNotFoundException
    //   47	64	952	android/content/pm/PackageManager$NameNotFoundException
    //   122	126	952	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void e(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    QLog.d("QPSafeCheck", 2, "IsAppRunning");
    Object localObject2 = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
    while (i < ((List)localObject2).size())
    {
      if (a(paramReqMQScanRequest.string_check_target.get(), ((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(i)).processName)) {
        try
        {
          paramReqMQScanRequest = ((PackageManager)localObject1).getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject2.get(i)).pkgList[0], 1);
          localObject1 = new safecheckPB.ReportItem();
          ((safecheckPB.ReportItem)localObject1).string_target_packname.set(paramReqMQScanRequest.packageName);
          ((safecheckPB.ReportItem)localObject1).string_target_md5.set(SecUtil.getFileMd5(paramReqMQScanRequest.applicationInfo.sourceDir));
          paramRspMQScanReport.rpt_check_item.add((MessageMicro)localObject1);
          paramRspMQScanReport.uint32_check_count.set(1);
          return;
        }
        catch (RuntimeException paramReqMQScanRequest)
        {
          paramReqMQScanRequest.printStackTrace();
          return;
        }
        catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
        {
          paramReqMQScanRequest.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void f(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int i = 0;
    Object localObject = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    paramReqMQScanRequest = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    int j = 0;
    for (;;)
    {
      if (j < ((List)localObject).size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject.get(j)).pkgList[0], 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            i += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(i);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      j += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QPSafeCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */