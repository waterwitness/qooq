package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

public class TroopFileTransferManager$TaskHttpUpload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpUpload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private HttpResponse a(HttpClient paramHttpClient, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramHttpClient == null) || (paramString == null) || (paramArrayOfByte == null)) {}
    do
    {
      for (;;)
      {
        return null;
        HttpPost localHttpPost = new HttpPost(paramString);
        localHttpPost.setHeader("User-Agent", "TroopFile");
        localHttpPost.setHeader("Content-Type", "text/octet");
        localHttpPost.setHeader("Connection", "keep-alive");
        if (NetworkUtil.i(BaseApplication.getContext()))
        {
          localHttpPost.setHeader("Net-type", "Wifi");
          localHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
        }
        try
        {
          paramHttpClient = paramHttpClient.execute(localHttpPost);
          return paramHttpClient;
          localHttpPost.setHeader("Net-type", "gprs");
        }
        catch (ClientProtocolException paramHttpClient)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "ClientProtocolException, url" + paramString);
          }
          paramHttpClient.printStackTrace();
          return null;
        }
        catch (IOException paramHttpClient)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "IOException, url" + paramString);
          }
          paramHttpClient.printStackTrace();
          return null;
        }
        catch (IllegalArgumentException paramHttpClient)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("TroopFileTransferManager", 2, "IllegalArgumentException, url" + paramString);
            return null;
          }
        }
        catch (Exception paramHttpClient) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopFileTransferManager", 2, "Exception, url" + paramString);
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   4: getfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   7: lstore 10
    //   9: aload_0
    //   10: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   13: aload_0
    //   14: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   17: invokevirtual 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   20: ifeq +4 -> 24
    //   23: return
    //   24: new 146	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: getfield 150	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   35: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: iconst_0
    //   45: putfield 155	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   48: aload_0
    //   49: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   52: invokevirtual 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   55: ifnull +1814 -> 1869
    //   58: aload_0
    //   59: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   62: invokevirtual 158	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   65: iconst_5
    //   66: invokeinterface 164 2 0
    //   71: astore_2
    //   72: iconst_0
    //   73: istore 7
    //   75: sipush 1024
    //   78: istore 8
    //   80: iload 7
    //   82: istore 9
    //   84: iload 7
    //   86: iconst_3
    //   87: if_icmpgt +228 -> 315
    //   90: iload 7
    //   92: ifle +118 -> 210
    //   95: invokestatic 59	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   98: invokestatic 167	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   101: ifne +52 -> 153
    //   104: aload_0
    //   105: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   108: aload_0
    //   109: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   112: iconst_3
    //   113: bipush 106
    //   115: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   118: return
    //   119: astore_1
    //   120: invokestatic 173	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   123: ifeq +11 -> 134
    //   126: ldc 94
    //   128: iconst_4
    //   129: ldc -81
    //   131: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_1
    //   135: invokevirtual 176	java/lang/InterruptedException:printStackTrace	()V
    //   138: aload_0
    //   139: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   142: aload_0
    //   143: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   146: iconst_3
    //   147: bipush 102
    //   149: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   152: return
    //   153: iconst_0
    //   154: istore 9
    //   156: iload 9
    //   158: iload 7
    //   160: bipush 100
    //   162: imul
    //   163: if_icmpge +47 -> 210
    //   166: ldc2_w 177
    //   169: invokestatic 184	java/lang/Thread:sleep	(J)V
    //   172: aload_0
    //   173: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   176: aload_0
    //   177: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   180: invokevirtual 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   183: ifne -160 -> 23
    //   186: invokestatic 59	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   189: invokestatic 167	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   192: ifne +1682 -> 1874
    //   195: aload_0
    //   196: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   199: aload_0
    //   200: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: iconst_3
    //   204: bipush 106
    //   206: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   209: return
    //   210: aload_0
    //   211: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   214: aload_0
    //   215: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   218: invokevirtual 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   221: ifne -198 -> 23
    //   224: aload 4
    //   226: invokevirtual 188	java/io/File:length	()J
    //   229: aload_0
    //   230: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   233: getfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   236: lcmp
    //   237: ifeq +19 -> 256
    //   240: aload_0
    //   241: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   244: aload_0
    //   245: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   248: iconst_3
    //   249: sipush 206
    //   252: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   255: return
    //   256: iload 7
    //   258: iconst_1
    //   259: iadd
    //   260: istore 7
    //   262: aload_0
    //   263: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   266: iload 7
    //   268: putfield 155	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   271: iload 8
    //   273: newarray <illegal type>
    //   275: astore 5
    //   277: new 193	java/io/FileInputStream
    //   280: dup
    //   281: aload 4
    //   283: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   286: astore_1
    //   287: aload_1
    //   288: lload 10
    //   290: invokevirtual 200	java/io/FileInputStream:skip	(J)J
    //   293: pop2
    //   294: aload_1
    //   295: aload 5
    //   297: invokevirtual 204	java/io/FileInputStream:read	([B)I
    //   300: istore 8
    //   302: aload_1
    //   303: invokevirtual 207	java/io/FileInputStream:close	()V
    //   306: iload 8
    //   308: ifge +152 -> 460
    //   311: iload 7
    //   313: istore 9
    //   315: iload 9
    //   317: iconst_3
    //   318: if_icmple +1265 -> 1583
    //   321: aload_0
    //   322: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   325: aload_0
    //   326: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   329: iconst_3
    //   330: bipush 105
    //   332: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   335: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +34 -> 372
    //   341: ldc 94
    //   343: iconst_2
    //   344: new 96	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   351: ldc -47
    //   353: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   360: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   363: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_0
    //   373: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   376: aconst_null
    //   377: putfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   380: aload_0
    //   381: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   384: aconst_null
    //   385: putfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   388: return
    //   389: astore_1
    //   390: aload_0
    //   391: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   394: aload_0
    //   395: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   398: iconst_3
    //   399: sipush 201
    //   402: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   405: return
    //   406: astore_1
    //   407: aload_1
    //   408: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   411: goto -105 -> 306
    //   414: astore_2
    //   415: aload_2
    //   416: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   419: aload_0
    //   420: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   423: aload_0
    //   424: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   427: iconst_3
    //   428: sipush 203
    //   431: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   434: aload_1
    //   435: invokevirtual 207	java/io/FileInputStream:close	()V
    //   438: return
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   444: return
    //   445: astore_2
    //   446: aload_1
    //   447: invokevirtual 207	java/io/FileInputStream:close	()V
    //   450: aload_2
    //   451: athrow
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   457: goto -7 -> 450
    //   460: aload_0
    //   461: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   464: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   467: arraylength
    //   468: iconst_2
    //   469: iadd
    //   470: iconst_2
    //   471: iadd
    //   472: aload_0
    //   473: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   476: getfield 219	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   479: arraylength
    //   480: iadd
    //   481: bipush 20
    //   483: iadd
    //   484: iload 8
    //   486: iadd
    //   487: istore 9
    //   489: new 221	java/io/ByteArrayOutputStream
    //   492: dup
    //   493: iload 9
    //   495: bipush 16
    //   497: iadd
    //   498: invokespecial 224	java/io/ByteArrayOutputStream:<init>	(I)V
    //   501: astore_1
    //   502: new 226	java/io/DataOutputStream
    //   505: dup
    //   506: aload_1
    //   507: invokespecial 229	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   510: astore_3
    //   511: aload_3
    //   512: ldc -26
    //   514: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   517: aload_3
    //   518: sipush 1007
    //   521: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   524: aload_3
    //   525: iconst_0
    //   526: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   529: aload_3
    //   530: iload 9
    //   532: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   535: aload_3
    //   536: aload_0
    //   537: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   540: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   543: arraylength
    //   544: invokevirtual 236	java/io/DataOutputStream:writeShort	(I)V
    //   547: aload_3
    //   548: aload_0
    //   549: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   552: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   555: invokevirtual 239	java/io/DataOutputStream:write	([B)V
    //   558: aload_3
    //   559: aload_0
    //   560: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   563: getfield 219	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   566: arraylength
    //   567: invokevirtual 236	java/io/DataOutputStream:writeShort	(I)V
    //   570: aload_3
    //   571: aload_0
    //   572: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   575: getfield 219	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   578: invokevirtual 239	java/io/DataOutputStream:write	([B)V
    //   581: aload_3
    //   582: aload_0
    //   583: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   586: getfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   589: ldc2_w 240
    //   592: land
    //   593: l2i
    //   594: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   597: aload_3
    //   598: ldc2_w 240
    //   601: lload 10
    //   603: land
    //   604: l2i
    //   605: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   608: aload_3
    //   609: iload 8
    //   611: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   614: aload_3
    //   615: aload_0
    //   616: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   619: getfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   622: bipush 32
    //   624: lshr
    //   625: l2i
    //   626: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   629: aload_3
    //   630: lload 10
    //   632: bipush 32
    //   634: lshr
    //   635: l2i
    //   636: invokevirtual 233	java/io/DataOutputStream:writeInt	(I)V
    //   639: aload_3
    //   640: aload 5
    //   642: iconst_0
    //   643: iload 8
    //   645: invokevirtual 244	java/io/DataOutputStream:write	([BII)V
    //   648: aload_1
    //   649: invokevirtual 248	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   652: astore 5
    //   654: aload_1
    //   655: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   658: aload_3
    //   659: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   662: aconst_null
    //   663: astore_1
    //   664: aconst_null
    //   665: astore_3
    //   666: aload_2
    //   667: ifnull +190 -> 857
    //   670: aload_3
    //   671: astore_1
    //   672: aload_2
    //   673: invokeinterface 256 1 0
    //   678: ifle +179 -> 857
    //   681: aload_2
    //   682: iconst_0
    //   683: invokeinterface 260 2 0
    //   688: checkcast 262	mqq/manager/ProxyIpManager$ProxyIp
    //   691: astore_3
    //   692: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   695: ifeq +36 -> 731
    //   698: ldc 94
    //   700: iconst_2
    //   701: ldc_w 264
    //   704: iconst_2
    //   705: anewarray 266	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: aload_3
    //   711: getfield 269	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: aload_3
    //   718: getfield 272	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   721: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   724: aastore
    //   725: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   728: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   731: ldc_w 286
    //   734: iconst_5
    //   735: anewarray 266	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload_3
    //   741: getfield 269	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: lload 10
    //   749: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   752: aastore
    //   753: dup
    //   754: iconst_2
    //   755: iload 8
    //   757: i2l
    //   758: lload 10
    //   760: ladd
    //   761: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   764: aastore
    //   765: dup
    //   766: iconst_3
    //   767: aload_0
    //   768: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   771: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   774: aastore
    //   775: dup
    //   776: iconst_4
    //   777: bipush 80
    //   779: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   782: aastore
    //   783: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   786: astore_1
    //   787: iconst_0
    //   788: aload_3
    //   789: getfield 272	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   792: sipush 10000
    //   795: sipush 20000
    //   798: invokestatic 296	com/dataline/util/HttpUtil:a	(ZIII)Lorg/apache/http/client/HttpClient;
    //   801: astore 6
    //   803: aload_0
    //   804: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   807: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   810: putfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   813: aload_0
    //   814: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   817: aload_1
    //   818: putfield 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   821: aload_0
    //   822: aload 6
    //   824: aload_1
    //   825: aload 5
    //   827: invokespecial 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   830: astore_1
    //   831: aload_1
    //   832: ifnull +174 -> 1006
    //   835: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq +1028 -> 1866
    //   841: ldc 94
    //   843: iconst_2
    //   844: ldc_w 311
    //   847: iconst_0
    //   848: anewarray 266	java/lang/Object
    //   851: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   854: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   857: aload_1
    //   858: astore_3
    //   859: aload_1
    //   860: ifnonnull +222 -> 1082
    //   863: invokestatic 314	com/dataline/util/HttpUtil:a	()Lcom/dataline/util/HttpUtil$NetworkProxy;
    //   866: ifnull +1017 -> 1883
    //   869: iconst_1
    //   870: istore 20
    //   872: iconst_0
    //   873: iload 20
    //   875: sipush 10000
    //   878: sipush 20000
    //   881: invokestatic 317	com/dataline/util/HttpUtil:a	(ZZII)Lorg/apache/http/client/HttpClient;
    //   884: astore_1
    //   885: ldc_w 319
    //   888: iconst_3
    //   889: anewarray 266	java/lang/Object
    //   892: dup
    //   893: iconst_0
    //   894: aload_0
    //   895: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   898: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   901: aastore
    //   902: dup
    //   903: iconst_1
    //   904: lload 10
    //   906: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   909: aastore
    //   910: dup
    //   911: iconst_2
    //   912: iload 8
    //   914: i2l
    //   915: lload 10
    //   917: ladd
    //   918: invokestatic 291	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   921: aastore
    //   922: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   925: astore_3
    //   926: aload_0
    //   927: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   930: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   933: putfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   936: aload_0
    //   937: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   940: aload_3
    //   941: putfield 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
    //   944: aload_0
    //   945: aload_1
    //   946: aload_3
    //   947: aload 5
    //   949: invokespecial 309	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
    //   952: astore_1
    //   953: aload_1
    //   954: ifnonnull +102 -> 1056
    //   957: sipush 16384
    //   960: istore 8
    //   962: goto -882 -> 80
    //   965: astore_2
    //   966: aload_2
    //   967: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   970: aload_0
    //   971: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   974: aload_0
    //   975: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   978: iconst_3
    //   979: bipush 102
    //   981: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   984: aload_1
    //   985: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   988: aload_3
    //   989: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   992: return
    //   993: astore_1
    //   994: return
    //   995: astore_2
    //   996: aload_1
    //   997: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   1000: aload_3
    //   1001: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   1004: aload_2
    //   1005: athrow
    //   1006: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq +36 -> 1045
    //   1012: ldc 94
    //   1014: iconst_2
    //   1015: ldc_w 321
    //   1018: iconst_2
    //   1019: anewarray 266	java/lang/Object
    //   1022: dup
    //   1023: iconst_0
    //   1024: aload_3
    //   1025: getfield 269	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_1
    //   1031: aload_3
    //   1032: getfield 272	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   1035: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1038: aastore
    //   1039: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1042: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1045: aload_2
    //   1046: iconst_0
    //   1047: invokeinterface 324 2 0
    //   1052: pop
    //   1053: goto -381 -> 672
    //   1056: aload_1
    //   1057: astore_3
    //   1058: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1061: ifeq +21 -> 1082
    //   1064: ldc 94
    //   1066: iconst_2
    //   1067: ldc_w 326
    //   1070: iconst_0
    //   1071: anewarray 266	java/lang/Object
    //   1074: invokestatic 284	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1077: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1080: aload_1
    //   1081: astore_3
    //   1082: aload_3
    //   1083: invokeinterface 332 1 0
    //   1088: astore_1
    //   1089: aload_1
    //   1090: invokeinterface 337 1 0
    //   1095: sipush 200
    //   1098: if_icmpeq +222 -> 1320
    //   1101: aload_1
    //   1102: invokeinterface 337 1 0
    //   1107: sipush 206
    //   1110: if_icmpeq +210 -> 1320
    //   1113: aload_3
    //   1114: invokeinterface 341 1 0
    //   1119: astore_1
    //   1120: aload_1
    //   1121: ifnull +94 -> 1215
    //   1124: new 96	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1131: astore 5
    //   1133: aload_1
    //   1134: arraylength
    //   1135: istore 9
    //   1137: iconst_0
    //   1138: istore 8
    //   1140: iload 8
    //   1142: iload 9
    //   1144: if_icmpge +59 -> 1203
    //   1147: aload_1
    //   1148: iload 8
    //   1150: aaload
    //   1151: astore 6
    //   1153: aload 5
    //   1155: ldc_w 343
    //   1158: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: aload 6
    //   1163: invokeinterface 348 1 0
    //   1168: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: ldc_w 350
    //   1174: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: aload 6
    //   1179: invokeinterface 353 1 0
    //   1184: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc_w 355
    //   1190: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: iload 8
    //   1196: iconst_1
    //   1197: iadd
    //   1198: istore 8
    //   1200: goto -60 -> 1140
    //   1203: aload_0
    //   1204: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1207: aload 5
    //   1209: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: putfield 358	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
    //   1215: aload_3
    //   1216: ldc_w 360
    //   1219: invokeinterface 364 2 0
    //   1224: astore_1
    //   1225: aload_1
    //   1226: ifnull +632 -> 1858
    //   1229: aload_1
    //   1230: invokeinterface 353 1 0
    //   1235: ifnull +623 -> 1858
    //   1238: aload_1
    //   1239: invokeinterface 353 1 0
    //   1244: ldc_w 366
    //   1247: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1250: ifeq +9 -> 1259
    //   1253: iconst_4
    //   1254: istore 9
    //   1256: goto -941 -> 315
    //   1259: aload_1
    //   1260: invokeinterface 353 1 0
    //   1265: ldc_w 372
    //   1268: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1271: ifne +33 -> 1304
    //   1274: aload_1
    //   1275: invokeinterface 353 1 0
    //   1280: ldc_w 374
    //   1283: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1286: ifne +18 -> 1304
    //   1289: aload_1
    //   1290: invokeinterface 353 1 0
    //   1295: ldc_w 376
    //   1298: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1301: ifeq +557 -> 1858
    //   1304: aload_0
    //   1305: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1308: aload_0
    //   1309: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1312: iconst_3
    //   1313: sipush 206
    //   1316: invokevirtual 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1319: return
    //   1320: aload_0
    //   1321: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1324: iconst_0
    //   1325: aload 5
    //   1327: arraylength
    //   1328: i2l
    //   1329: invokevirtual 379	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1332: lload 10
    //   1334: lstore 12
    //   1336: lload 10
    //   1338: lstore 14
    //   1340: new 381	java/io/DataInputStream
    //   1343: dup
    //   1344: aload_3
    //   1345: invokeinterface 385 1 0
    //   1350: invokeinterface 391 1 0
    //   1355: invokespecial 394	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   1358: astore_1
    //   1359: lload 10
    //   1361: lstore 12
    //   1363: lload 10
    //   1365: lstore 14
    //   1367: aload_1
    //   1368: ldc2_w 395
    //   1371: invokevirtual 397	java/io/DataInputStream:skip	(J)J
    //   1374: pop2
    //   1375: lload 10
    //   1377: lstore 12
    //   1379: lload 10
    //   1381: lstore 14
    //   1383: aload_1
    //   1384: invokevirtual 401	java/io/DataInputStream:readByte	()B
    //   1387: ifeq +9 -> 1396
    //   1390: iconst_0
    //   1391: istore 9
    //   1393: goto -1078 -> 315
    //   1396: lload 10
    //   1398: lstore 12
    //   1400: lload 10
    //   1402: lstore 14
    //   1404: aload_1
    //   1405: invokevirtual 404	java/io/DataInputStream:readInt	()I
    //   1408: i2l
    //   1409: lstore 16
    //   1411: lload 10
    //   1413: lstore 12
    //   1415: lload 10
    //   1417: lstore 14
    //   1419: aload_1
    //   1420: invokevirtual 404	java/io/DataInputStream:readInt	()I
    //   1423: i2l
    //   1424: lstore 18
    //   1426: lload 10
    //   1428: lstore 12
    //   1430: lload 10
    //   1432: lstore 14
    //   1434: aload_3
    //   1435: invokeinterface 385 1 0
    //   1440: invokeinterface 407 1 0
    //   1445: ldc2_w 408
    //   1448: lload 16
    //   1450: land
    //   1451: lload 18
    //   1453: bipush 32
    //   1455: lshl
    //   1456: lor
    //   1457: lstore 10
    //   1459: lload 10
    //   1461: lstore 12
    //   1463: lload 10
    //   1465: lstore 14
    //   1467: aload_0
    //   1468: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1471: getfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1474: lload 10
    //   1476: lcmp
    //   1477: ifgt +61 -> 1538
    //   1480: lload 10
    //   1482: lstore 12
    //   1484: lload 10
    //   1486: lstore 14
    //   1488: aload_0
    //   1489: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1492: lload 10
    //   1494: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1497: lload 10
    //   1499: lstore 12
    //   1501: lload 10
    //   1503: lstore 14
    //   1505: aload_0
    //   1506: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1509: aload_0
    //   1510: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1513: getfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1516: putfield 412	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1519: lload 10
    //   1521: lstore 12
    //   1523: lload 10
    //   1525: lstore 14
    //   1527: aload_0
    //   1528: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1531: aload_0
    //   1532: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1535: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1538: sipush 16384
    //   1541: istore 8
    //   1543: iconst_0
    //   1544: istore 7
    //   1546: goto -1466 -> 80
    //   1549: astore_1
    //   1550: aload_1
    //   1551: invokevirtual 416	java/lang/IllegalStateException:printStackTrace	()V
    //   1554: sipush 16384
    //   1557: istore 8
    //   1559: lload 12
    //   1561: lstore 10
    //   1563: goto -1483 -> 80
    //   1566: astore_1
    //   1567: aload_1
    //   1568: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   1571: sipush 16384
    //   1574: istore 8
    //   1576: lload 14
    //   1578: lstore 10
    //   1580: goto -1500 -> 80
    //   1583: aload_0
    //   1584: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1587: aload_0
    //   1588: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1591: getfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1594: putfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1597: aload_0
    //   1598: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1601: aload_0
    //   1602: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1605: bipush 6
    //   1607: invokevirtual 419	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1610: aload_0
    //   1611: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1614: aload_0
    //   1615: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1618: invokevirtual 421	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1621: aload_0
    //   1622: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1625: aconst_null
    //   1626: putfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   1629: aload_0
    //   1630: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1633: aconst_null
    //   1634: putfield 219	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   1637: aload_0
    //   1638: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1641: aload_0
    //   1642: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1645: aload_0
    //   1646: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1649: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1652: invokevirtual 431	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1655: iconst_1
    //   1656: invokevirtual 434	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1659: aload_0
    //   1660: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1663: getfield 437	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1666: astore_1
    //   1667: new 96	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1674: aload_0
    //   1675: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1678: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1681: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1684: ldc_w 442
    //   1687: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1693: astore_2
    //   1694: new 96	java/lang/StringBuilder
    //   1697: dup
    //   1698: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1701: astore_3
    //   1702: ldc_w 444
    //   1705: aload_0
    //   1706: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1709: getfield 447	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   1712: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1715: ifeq +123 -> 1838
    //   1718: iconst_0
    //   1719: istore 7
    //   1721: aload_1
    //   1722: ldc_w 449
    //   1725: ldc_w 451
    //   1728: ldc_w 442
    //   1731: ldc_w 453
    //   1734: ldc_w 455
    //   1737: iconst_0
    //   1738: iconst_0
    //   1739: aload_2
    //   1740: aload_3
    //   1741: iload 7
    //   1743: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1746: ldc_w 442
    //   1749: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: ldc_w 442
    //   1758: ldc_w 442
    //   1761: invokestatic 463	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1764: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1767: ifeq -1395 -> 372
    //   1770: new 96	java/lang/StringBuilder
    //   1773: dup
    //   1774: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1777: ldc_w 465
    //   1780: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_0
    //   1784: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1787: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1790: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1793: ldc_w 467
    //   1796: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: astore_1
    //   1800: ldc_w 444
    //   1803: aload_0
    //   1804: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1807: getfield 447	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
    //   1810: invokevirtual 370	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1813: ifeq +31 -> 1844
    //   1816: iconst_0
    //   1817: istore 7
    //   1819: ldc_w 469
    //   1822: iconst_2
    //   1823: aload_1
    //   1824: iload 7
    //   1826: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1835: goto -1463 -> 372
    //   1838: iconst_1
    //   1839: istore 7
    //   1841: goto -120 -> 1721
    //   1844: iconst_1
    //   1845: istore 7
    //   1847: goto -28 -> 1819
    //   1850: astore_1
    //   1851: goto -847 -> 1004
    //   1854: astore_1
    //   1855: goto -1193 -> 662
    //   1858: sipush 16384
    //   1861: istore 8
    //   1863: goto -1783 -> 80
    //   1866: goto -1009 -> 857
    //   1869: aconst_null
    //   1870: astore_2
    //   1871: goto -1799 -> 72
    //   1874: iload 9
    //   1876: iconst_1
    //   1877: iadd
    //   1878: istore 9
    //   1880: goto -1724 -> 156
    //   1883: iconst_0
    //   1884: istore 20
    //   1886: goto -1014 -> 872
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1889	0	this	TaskHttpUpload
    //   119	16	1	localInterruptedException	InterruptedException
    //   286	17	1	localFileInputStream	java.io.FileInputStream
    //   389	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   406	29	1	localIOException1	IOException
    //   439	8	1	localIOException2	IOException
    //   452	2	1	localIOException3	IOException
    //   501	484	1	localObject1	Object
    //   993	88	1	localException1	Exception
    //   1088	332	1	localObject2	Object
    //   1549	2	1	localIllegalStateException	IllegalStateException
    //   1566	2	1	localIOException4	IOException
    //   1666	158	1	localObject3	Object
    //   1850	1	1	localException2	Exception
    //   1854	1	1	localException3	Exception
    //   71	1	2	localList	java.util.List
    //   414	2	2	localIOException5	IOException
    //   445	237	2	localObject4	Object
    //   965	2	2	localIOException6	IOException
    //   995	51	2	localObject5	Object
    //   1693	178	2	str	String
    //   510	1231	3	localObject6	Object
    //   38	244	4	localFile	java.io.File
    //   275	1051	5	localObject7	Object
    //   801	377	6	localHttpClient	HttpClient
    //   73	1773	7	i	int
    //   78	1784	8	j	int
    //   82	1797	9	k	int
    //   7	1572	10	l1	long
    //   1334	226	12	l2	long
    //   1338	239	14	l3	long
    //   1409	40	16	l4	long
    //   1424	28	18	l5	long
    //   870	1015	20	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   95	118	119	java/lang/InterruptedException
    //   166	209	119	java/lang/InterruptedException
    //   210	255	119	java/lang/InterruptedException
    //   262	277	119	java/lang/InterruptedException
    //   277	287	119	java/lang/InterruptedException
    //   302	306	119	java/lang/InterruptedException
    //   390	405	119	java/lang/InterruptedException
    //   407	411	119	java/lang/InterruptedException
    //   434	438	119	java/lang/InterruptedException
    //   440	444	119	java/lang/InterruptedException
    //   446	450	119	java/lang/InterruptedException
    //   450	452	119	java/lang/InterruptedException
    //   453	457	119	java/lang/InterruptedException
    //   460	511	119	java/lang/InterruptedException
    //   654	662	119	java/lang/InterruptedException
    //   672	731	119	java/lang/InterruptedException
    //   731	831	119	java/lang/InterruptedException
    //   835	857	119	java/lang/InterruptedException
    //   863	869	119	java/lang/InterruptedException
    //   872	953	119	java/lang/InterruptedException
    //   984	992	119	java/lang/InterruptedException
    //   996	1004	119	java/lang/InterruptedException
    //   1004	1006	119	java/lang/InterruptedException
    //   1006	1045	119	java/lang/InterruptedException
    //   1045	1053	119	java/lang/InterruptedException
    //   1058	1080	119	java/lang/InterruptedException
    //   1082	1120	119	java/lang/InterruptedException
    //   1124	1137	119	java/lang/InterruptedException
    //   1153	1194	119	java/lang/InterruptedException
    //   1203	1215	119	java/lang/InterruptedException
    //   1215	1225	119	java/lang/InterruptedException
    //   1229	1253	119	java/lang/InterruptedException
    //   1259	1304	119	java/lang/InterruptedException
    //   1304	1319	119	java/lang/InterruptedException
    //   1320	1332	119	java/lang/InterruptedException
    //   1340	1359	119	java/lang/InterruptedException
    //   1367	1375	119	java/lang/InterruptedException
    //   1383	1390	119	java/lang/InterruptedException
    //   1404	1411	119	java/lang/InterruptedException
    //   1419	1426	119	java/lang/InterruptedException
    //   1434	1445	119	java/lang/InterruptedException
    //   1467	1480	119	java/lang/InterruptedException
    //   1488	1497	119	java/lang/InterruptedException
    //   1505	1519	119	java/lang/InterruptedException
    //   1527	1538	119	java/lang/InterruptedException
    //   1550	1554	119	java/lang/InterruptedException
    //   1567	1571	119	java/lang/InterruptedException
    //   277	287	389	java/io/FileNotFoundException
    //   302	306	406	java/io/IOException
    //   287	302	414	java/io/IOException
    //   434	438	439	java/io/IOException
    //   287	302	445	finally
    //   415	434	445	finally
    //   446	450	452	java/io/IOException
    //   511	654	965	java/io/IOException
    //   984	992	993	java/lang/Exception
    //   511	654	995	finally
    //   966	984	995	finally
    //   1340	1359	1549	java/lang/IllegalStateException
    //   1367	1375	1549	java/lang/IllegalStateException
    //   1383	1390	1549	java/lang/IllegalStateException
    //   1404	1411	1549	java/lang/IllegalStateException
    //   1419	1426	1549	java/lang/IllegalStateException
    //   1434	1445	1549	java/lang/IllegalStateException
    //   1467	1480	1549	java/lang/IllegalStateException
    //   1488	1497	1549	java/lang/IllegalStateException
    //   1505	1519	1549	java/lang/IllegalStateException
    //   1527	1538	1549	java/lang/IllegalStateException
    //   1340	1359	1566	java/io/IOException
    //   1367	1375	1566	java/io/IOException
    //   1383	1390	1566	java/io/IOException
    //   1404	1411	1566	java/io/IOException
    //   1419	1426	1566	java/io/IOException
    //   1434	1445	1566	java/io/IOException
    //   1467	1480	1566	java/io/IOException
    //   1488	1497	1566	java/io/IOException
    //   1505	1519	1566	java/io/IOException
    //   1527	1538	1566	java/io/IOException
    //   996	1004	1850	java/lang/Exception
    //   654	662	1854	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskHttpUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */