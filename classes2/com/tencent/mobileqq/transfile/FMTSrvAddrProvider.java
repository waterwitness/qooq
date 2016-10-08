package com.tencent.mobileqq.transfile;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.FmtIPInfo;
import ConfigPush.NetSegConf;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.RspBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_apply.ptt_apply.Addr;
import tencent.im.cs.ptt_apply.ptt_apply.QQApplyAuthkeyRsp;
import vas;

public final class FMTSrvAddrProvider
{
  public static final int a = 0;
  private static FMTSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider;
  public static final String a = "FMT_ADDR";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  public static final int b = 1;
  public static final int c = 2;
  private static final String c = AppConstants.cP + "fmtSrvAddr.ini";
  public static final int d = 1;
  private static final String d = AppConstants.cP + "srvAddr.ini";
  public static final int e = 2;
  private static final String e = AppConstants.cP + "ipDownAddr.ini";
  public static final int f = 3;
  private static final String f = AppConstants.cP + "ipDownAddr.tmp";
  public static final int g = 4;
  private long jdField_a_of_type_Long = -1L;
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = b();
  private subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
  private PttIpSaver jdField_a_of_type_ComTencentMobileqqPttPttIpSaver = new PttIpSaver();
  private FMTSrvAddrProvider.PttIpList jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList = new FMTSrvAddrProvider.PttIpList();
  private StructLongMessageIpSaver jdField_a_of_type_ComTencentMobileqqTransfileStructLongMessageIpSaver = new StructLongMessageIpSaver();
  public Object a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private vas jdField_a_of_type_Vas = new vas(this);
  private FileStoragePushFSSvcList jdField_b_of_type_ConfigPushFileStoragePushFSSvcList;
  private String jdField_b_of_type_JavaLangString = "";
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private int h = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private FMTSrvAddrProvider()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    f();
    d();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 6) {}
    do
    {
      return 1;
      if (paramInt == 7) {
        return 2;
      }
      if (paramInt == 8) {
        return 3;
      }
      if (paramInt == 9) {
        return 4;
      }
    } while (paramInt != 10);
    return 5;
  }
  
  public static FMTSrvAddrProvider a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider = new FMTSrvAddrProvider();
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider;
    }
  }
  
  public static String a(int paramInt)
  {
    return (paramInt >> 0 & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  private byte[] a(FMTSrvAddrProvider.PttIpList paramPttIpList)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    int k;
    int j;
    if (paramPttIpList != null)
    {
      localObject1 = (byte[][])null;
      localObject3 = (byte[][])null;
      if ((paramPttIpList.jdField_a_of_type_JavaUtilArrayList == null) || (paramPttIpList.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label884;
      }
      localObject1 = new byte[paramPttIpList.jdField_a_of_type_JavaUtilArrayList.size()][];
      localObject2 = localObject3;
      if (paramPttIpList.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject2 = localObject3;
        if (paramPttIpList.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          localObject2 = new byte[paramPttIpList.jdField_b_of_type_JavaUtilArrayList.size()][];
        }
      }
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      k = 0;
      j = 0;
    }
    label872:
    label878:
    label884:
    label887:
    label898:
    for (;;)
    {
      try
      {
        if (paramPttIpList.jdField_a_of_type_JavaLangString == null) {
          break label878;
        }
        localDataOutputStream.writeUTF(paramPttIpList.jdField_a_of_type_JavaLangString);
        localObject3 = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k = 0 + (localObject3.length + 3);
        j = 1;
        if (paramPttIpList.jdField_b_of_type_JavaLangString == null) {
          break label872;
        }
        localDataOutputStream.writeUTF(paramPttIpList.jdField_b_of_type_JavaLangString);
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k += arrayOfByte.length + 3;
        j += 1;
        i = j;
        m = k;
        Object localObject4;
        if (paramPttIpList.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i = j;
          m = k;
          if (paramPttIpList.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            m = 0;
            i = k;
            k = m;
            if (k >= paramPttIpList.jdField_a_of_type_JavaUtilArrayList.size()) {
              break label887;
            }
            localObject4 = (FileStorageServerListInfo)paramPttIpList.jdField_a_of_type_JavaUtilArrayList.get(k);
            localDataOutputStream.writeInt(((FileStorageServerListInfo)localObject4).iPort);
            localDataOutputStream.writeUTF(((FileStorageServerListInfo)localObject4).sIP);
            localObject1[k] = localByteArrayOutputStream.toByteArray();
            localByteArrayOutputStream.reset();
            i += localObject1[k].length + 3;
            j += 1;
            k += 1;
            continue;
          }
        }
        if ((paramPttIpList.jdField_b_of_type_JavaUtilArrayList != null) && (paramPttIpList.jdField_b_of_type_JavaUtilArrayList.size() > 0))
        {
          k = 0;
          j = m;
          if (k >= paramPttIpList.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label898;
          }
          localObject4 = (FileStorageServerListInfo)paramPttIpList.jdField_b_of_type_JavaUtilArrayList.get(k);
          localDataOutputStream.writeInt(((FileStorageServerListInfo)localObject4).iPort);
          localDataOutputStream.writeUTF(((FileStorageServerListInfo)localObject4).sIP);
          localObject2[k] = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.reset();
          j += localObject2[k].length + 3;
          i += 1;
          k += 1;
          continue;
          paramPttIpList = new byte[j + 2];
          paramPttIpList[0] = 0;
          paramPttIpList[1] = ((byte)i);
          j = 2;
          if (localObject3 != null)
          {
            paramPttIpList[2] = 1;
            localObject4 = PkgTools.a((short)localObject3.length);
            System.arraycopy(localObject4, 0, paramPttIpList, 3, localObject4.length);
            i = localObject4.length + 3;
            System.arraycopy(localObject3, 0, paramPttIpList, i, localObject3.length);
            j = i + localObject3.length;
          }
          i = j;
          if (arrayOfByte != null)
          {
            paramPttIpList[j] = 2;
            i = j + 1;
            localObject3 = PkgTools.a((short)arrayOfByte.length);
            System.arraycopy(localObject3, 0, paramPttIpList, i, localObject3.length);
            i += localObject3.length;
            System.arraycopy(arrayOfByte, 0, paramPttIpList, i, arrayOfByte.length);
            i += arrayOfByte.length;
          }
          j = i;
          if (localObject1 != null)
          {
            j = i;
            if (localObject1.length > 0)
            {
              k = 0;
              j = i;
              if (k < localObject1.length)
              {
                paramPttIpList[i] = 3;
                i += 1;
                localObject3 = PkgTools.a((short)localObject1[k].length);
                System.arraycopy(localObject3, 0, paramPttIpList, i, localObject3.length);
                i += localObject3.length;
                System.arraycopy(localObject1[k], 0, paramPttIpList, i, localObject1[k].length);
                j = localObject1[k].length;
                k += 1;
                i = j + i;
                continue;
              }
            }
          }
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            i = 0;
            if (i < localObject2.length)
            {
              paramPttIpList[j] = 4;
              j += 1;
              localObject1 = PkgTools.a((short)localObject2[i].length);
              System.arraycopy(localObject1, 0, paramPttIpList, j, localObject1.length);
              j += localObject1.length;
              System.arraycopy(localObject2[i], 0, paramPttIpList, j, localObject2[i].length);
              k = localObject2[i].length;
              j += k;
              i += 1;
              continue;
            }
          }
          if (localByteArrayOutputStream == null) {}
        }
        j = m;
      }
      catch (Throwable paramPttIpList)
      {
        paramPttIpList = paramPttIpList;
        paramPttIpList.printStackTrace();
        return null;
      }
      finally
      {
        if (localByteArrayOutputStream != null) {}
        try
        {
          localByteArrayOutputStream.close();
          if (localDataOutputStream != null) {
            localDataOutputStream.close();
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
      }
      continue;
      byte[] arrayOfByte = null;
      continue;
      localObject3 = null;
      continue;
      break;
      int m = i;
      int i = j;
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    default: 
      return -1;
    case 12: 
      return 1;
    case 13: 
      return 2;
    case 14: 
      return 3;
    case 15: 
      return 7;
    }
    return 16;
  }
  
  /* Error */
  private FileStoragePushFSSvcList b()
  {
    // Byte code:
    //   0: getstatic 68	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:d	Ljava/lang/String;
    //   3: invokestatic 233	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 239	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +20 -> 33
    //   16: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +148 -> 167
    //   22: ldc 11
    //   24: iconst_2
    //   25: ldc -9
    //   27: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: goto +137 -> 167
    //   33: new 252	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: sipush 1024
    //   45: newarray <illegal type>
    //   47: astore_1
    //   48: new 168	java/io/ByteArrayOutputStream
    //   51: dup
    //   52: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   55: astore_3
    //   56: aload_2
    //   57: aload_1
    //   58: invokevirtual 259	java/io/FileInputStream:read	([B)I
    //   61: istore 4
    //   63: iload 4
    //   65: iconst_m1
    //   66: if_icmpeq +38 -> 104
    //   69: aload_3
    //   70: aload_1
    //   71: iconst_0
    //   72: iload 4
    //   74: invokevirtual 263	java/io/ByteArrayOutputStream:write	([BII)V
    //   77: goto -21 -> 56
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_1
    //   83: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +12 -> 98
    //   89: ldc 11
    //   91: iconst_2
    //   92: ldc_w 265
    //   95: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_2
    //   99: invokevirtual 266	java/io/FileNotFoundException:printStackTrace	()V
    //   102: aload_1
    //   103: areturn
    //   104: new 268	com/qq/taf/jce/JceInputStream
    //   107: dup
    //   108: aload_3
    //   109: invokevirtual 184	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: invokespecial 271	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   115: astore_3
    //   116: new 273	ConfigPush/FileStoragePushFSSvcList
    //   119: dup
    //   120: invokespecial 274	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   123: astore_1
    //   124: aload_1
    //   125: aload_3
    //   126: invokevirtual 278	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   129: aload_2
    //   130: invokevirtual 279	java/io/FileInputStream:close	()V
    //   133: aload_1
    //   134: areturn
    //   135: astore_2
    //   136: goto -53 -> 83
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc 11
    //   150: iconst_2
    //   151: ldc_w 281
    //   154: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_2
    //   158: invokevirtual 282	java/lang/Exception:printStackTrace	()V
    //   161: aload_1
    //   162: areturn
    //   163: astore_2
    //   164: goto -22 -> 142
    //   167: aconst_null
    //   168: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	FMTSrvAddrProvider
    //   6	156	1	localObject1	Object
    //   41	16	2	localFileInputStream	java.io.FileInputStream
    //   80	50	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   135	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   139	19	2	localException1	Exception
    //   163	1	2	localException2	Exception
    //   55	71	3	localObject2	Object
    //   61	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	30	80	java/io/FileNotFoundException
    //   33	56	80	java/io/FileNotFoundException
    //   56	63	80	java/io/FileNotFoundException
    //   69	77	80	java/io/FileNotFoundException
    //   104	124	80	java/io/FileNotFoundException
    //   124	133	135	java/io/FileNotFoundException
    //   0	30	139	java/lang/Exception
    //   33	56	139	java/lang/Exception
    //   56	63	139	java/lang/Exception
    //   69	77	139	java/lang/Exception
    //   104	124	139	java/lang/Exception
    //   124	133	163	java/lang/Exception
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider == null) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider.c();
  }
  
  private ArrayList c(int paramInt)
  {
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      switch (paramInt)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        return d(a(paramInt));
      case 0: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUpLoadList;
      case 1: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vPicDownLoadList;
      case 2: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      case 3: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vQzoneProxyServiceList;
      case 4: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUrlEncodeServiceList;
      case 5: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vVipEmotionList;
      case 11: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 17: 
        return e(b(paramInt));
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.a(this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver.b());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  private void c(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      File localFile = FileUtils.a(c);
      if (paramFileStoragePushFSSvcList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER writeToFile list==null");
        }
        if ((localFile == null) || (!localFile.exists())) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER writeToFile list==null,delete old file?");
        }
        localFile.delete();
        return;
      }
      Object localObject = new JceOutputStream();
      paramFileStoragePushFSSvcList.writeTo((JceOutputStream)localObject);
      localObject = ((JceOutputStream)localObject).toByteArray();
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile, false);
      localFileOutputStream.write((byte[])localObject);
      localFileOutputStream.close();
      localObject = new File(d);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localFile.renameTo((File)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER,writeToFile error", localException);
        }
      }
    }
    if ((paramFileStoragePushFSSvcList != null) && (QLog.isColorLevel()))
    {
      QLog.d("FMT_ADDR", 2, "FMT SERVER,writeToFile LIST persist OK");
      return;
    }
  }
  
  private ArrayList d(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.size())
      {
        Object localObject = (BigDataIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.get(i);
        if (((BigDataIpList)localObject).uService_type == paramInt)
        {
          localObject = ((BigDataIpList)localObject).vIplist;
          ArrayList localArrayList = new ArrayList();
          i = j;
          while (i < ((ArrayList)localObject).size())
          {
            FileStorageServerListInfo localFileStorageServerListInfo = new FileStorageServerListInfo();
            localFileStorageServerListInfo.sIP = ((BigDataIpInfo)((ArrayList)localObject).get(i)).sIp;
            localFileStorageServerListInfo.iPort = ((int)((BigDataIpInfo)((ArrayList)localObject).get(i)).uPort);
            localArrayList.add(localFileStorageServerListInfo);
            i += 1;
          }
          this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localArrayList);
          return localArrayList;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void d()
  {
    int i = 1;
    while (i < 7)
    {
      d(i);
      i += 1;
    }
    this.jdField_a_of_type_Vas.a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList);
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo != null))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.sGateIp;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null)
    {
      this.jdField_a_of_type_Long = -1L;
      this.jdField_b_of_type_JavaLangString = "";
    }
    b();
  }
  
  private ArrayList e(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_b_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
        {
          i = 0;
          if (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.size())
          {
            Object localObject1 = (DomainIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.get(i);
            if (((DomainIpList)localObject1).uDomain_type != paramInt) {
              break label346;
            }
            localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            if (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = NetworkUtil.a(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
              continue;
            }
            this.jdField_b_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localObject1);
            if (!QLog.isColorLevel()) {
              break label344;
            }
            localObject2 = new StringBuffer();
            Object localObject3 = ((ArrayList)localObject1).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label305;
            }
            FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject3).next();
            ((StringBuffer)localObject2).append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append(",");
            continue;
          }
        }
        return null;
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMT_ADDR", 2, localNoSuchFieldError.getMessage());
        }
      }
      label305:
      QLog.d("FMT_ADDR", 2, "Domain type=" + paramInt + ",iplist=" + ((StringBuffer)localObject2).toString());
      label344:
      return localNoSuchFieldError;
      label346:
      i += 1;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList = new FMTSrvAddrProvider.PttIpList();
    if (QLog.isDevelopLevel()) {
      QLog.d("SPD", 4, "Clear GroupPtt D-IpList");
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null) || (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist == null) || (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist.length == 0))
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList = a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public long a()
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = b();
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.fmtIPInfo != null)) {
      return localFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    return -1L;
  }
  
  public FileStoragePushFSSvcList a()
  {
    try
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.jdField_b_of_type_ConfigPushFileStoragePushFSSvcList;
      return localFileStoragePushFSSvcList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public HwConfig a()
  {
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null))
    {
      Object localObject1 = new StringBuilder().append("GetHighwayConfig  Has PbBuffer : ");
      boolean bool;
      if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null) {
        bool = true;
      }
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      for (;;)
      {
        QLog.d("FMT_ADDR", 2, String.valueOf(bool) + " IpList : " + this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.size());
        if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf.length > 0))
        {
          localObject3 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf;
          localObject1 = new subcmd0x501.RspBody();
          try
          {
            ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject3);
            if (localObject1 != null)
            {
              localObject1 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
              localObject3 = BaseApplicationImpl.a().a().getAccount();
              SessionInfo.updateSessionInfo(((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_httpconn_sig_session.get().toByteArray(), ((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_session_key.get().toByteArray(), (String)localObject3);
              localObject3 = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).rpt_msg_httpconn_addrs.get();
              if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
                break label840;
              }
              localObject3 = ((List)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject3).next();
                  if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).uint32_service_type.get() == 10)
                  {
                    localObject3 = new HwConfig();
                    ((HwConfig)localObject3).ipList = new ArrayList();
                    ((HwConfig)localObject3).netSegConfList = new ArrayList();
                    localObject5 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_addrs.get();
                    if ((localObject5 != null) && (((List)localObject5).size() != 0))
                    {
                      i = 0;
                      for (;;)
                      {
                        if (i < ((List)localObject5).size())
                        {
                          subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject5).get(i);
                          ArrayList localArrayList = ((HwConfig)localObject3).ipList;
                          String str = HwServlet.spliceCircleUrl(localIpAddr.uint32_ip.get());
                          int j = localIpAddr.uint32_port.get();
                          if (localIpAddr.uint32_same_isp.get() == 1)
                          {
                            bool = true;
                            localArrayList.add(new EndPoint(str, j, bool));
                            i += 1;
                            continue;
                            bool = false;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            int i;
            for (;;)
            {
              localException.printStackTrace();
              localObject2 = null;
              continue;
              bool = false;
            }
            localObject4 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_netsegconf.get();
            if ((localObject4 != null) && (((List)localObject4).size() != 0))
            {
              i = 0;
              while (i < ((List)localObject4).size())
              {
                localObject5 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject4).get(i);
                ((HwConfig)localObject3).netSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_curconnnum.get()));
                i += 1;
              }
            }
            if (((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_ip_learn_conf.has()) {
              ((HwConfig)localObject3).ipConf = ((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_ip_learn_conf.get());
            }
            if (((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_dyn_timeout_conf.has()) {
              ((HwConfig)localObject3).dtConf = ((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_dyn_timeout_conf.get());
            }
            if (((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_open_up_conf.has()) {
              ((HwConfig)localObject3).openUpConf = ((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_open_up_conf.get());
            }
            if (((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_short_video_conf.has())
            {
              ((HwConfig)localObject3).videoConf = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_short_video_conf;
              if (!((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_ptv_conf.has()) {
                break label660;
              }
              ((HwConfig)localObject3).ptvCof = ((subcmd0x501.SubCmd0x501Rspbody)localObject2).msg_ptv_conf;
            }
            for (;;)
            {
              return (HwConfig)localObject3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
              break;
              label660:
              if (QLog.isColorLevel()) {
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("FMT_ADDR", 2, "GetHighwayConfig cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
            }
          }
        }
      }
      while (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists != null)
      {
        localObject2 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BigDataIpList)((Iterator)localObject2).next();
          if ((((BigDataIpList)localObject3).uService_type == 10L) && (((BigDataIpList)localObject3).vIplist != null) && (((BigDataIpList)localObject3).netSegConfs != null))
          {
            localObject2 = new HwConfig();
            ((HwConfig)localObject2).ipList = new ArrayList();
            localObject4 = ((BigDataIpList)localObject3).vIplist.iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (BigDataIpInfo)((Iterator)localObject4).next();
                ((HwConfig)localObject2).ipList.add(new EndPoint(((BigDataIpInfo)localObject5).sIp, (int)((BigDataIpInfo)localObject5).uPort));
                continue;
                label840:
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("FMT_ADDR", 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
                break;
              }
            }
            ((HwConfig)localObject2).netSegConfList = new ArrayList();
            if (((BigDataIpList)localObject3).netSegConfs != null)
            {
              localObject3 = ((BigDataIpList)localObject3).netSegConfs.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (NetSegConf)((Iterator)localObject3).next();
                ((HwConfig)localObject2).netSegConfList.add(new HwNetSegConf(((NetSegConf)localObject4).uint32_net_type, ((NetSegConf)localObject4).uint32_segsize, ((NetSegConf)localObject4).uint32_segnum, ((NetSegConf)localObject4).uint32_curconnnum));
              }
            }
            QLog.d("FMT_ADDR", 1, "getBigDataDefaultIpList() successfully got channel(service type = 10)");
            return (HwConfig)localObject2;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 1, "getBigDataDefaultIpList() cannot find channel(service type = 10)");
    }
    return null;
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf = b();
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
        break label106;
      }
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: pic:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypted_pic.get() + ",url:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypt_request.get() + ",ctlFlag:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.uint32_ctrl_flag.get());
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
      label106:
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: none!");
    }
  }
  
  public PttIpSaver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver;
  }
  
  /* Error */
  public FMTSrvAddrProvider.PttIpList a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 4
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 765	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	([B)Z
    //   26: ifne +13 -> 39
    //   29: new 91	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   32: dup
    //   33: invokespecial 92	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_2
    //   42: aload 13
    //   44: astore 6
    //   46: aload 5
    //   48: astore_3
    //   49: aload_1
    //   50: ifnull +532 -> 582
    //   53: aload 10
    //   55: astore 7
    //   57: aload 9
    //   59: astore 8
    //   61: aload 4
    //   63: astore_2
    //   64: aload 13
    //   66: astore 6
    //   68: aload 5
    //   70: astore_3
    //   71: aload 12
    //   73: astore 4
    //   75: aload 11
    //   77: astore 5
    //   79: aload_1
    //   80: arraylength
    //   81: ifle +501 -> 582
    //   84: aload 10
    //   86: astore 7
    //   88: aload 9
    //   90: astore 8
    //   92: aload 12
    //   94: astore 4
    //   96: aload 11
    //   98: astore 5
    //   100: new 91	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   103: dup
    //   104: invokespecial 92	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   107: astore 9
    //   109: aload_1
    //   110: iconst_1
    //   111: baload
    //   112: istore 16
    //   114: iconst_0
    //   115: istore 14
    //   117: iconst_2
    //   118: istore 15
    //   120: aconst_null
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_2
    //   125: iload 14
    //   127: iload 16
    //   129: if_icmpge +444 -> 573
    //   132: aload_1
    //   133: iload 15
    //   135: baload
    //   136: istore 17
    //   138: iload 15
    //   140: iconst_1
    //   141: iadd
    //   142: istore 15
    //   144: iconst_2
    //   145: newarray <illegal type>
    //   147: astore_3
    //   148: aload_1
    //   149: iload 15
    //   151: aload_3
    //   152: iconst_0
    //   153: iconst_2
    //   154: invokestatic 215	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   157: iload 15
    //   159: iconst_2
    //   160: iadd
    //   161: istore 15
    //   163: aload_3
    //   164: iconst_0
    //   165: invokestatic 770	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   168: istore 18
    //   170: aload_1
    //   171: iload 15
    //   173: iload 18
    //   175: newarray <illegal type>
    //   177: iconst_0
    //   178: iload 18
    //   180: invokestatic 215	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   183: iload 17
    //   185: iconst_1
    //   186: if_icmpne +102 -> 288
    //   189: new 772	java/io/ByteArrayInputStream
    //   192: dup
    //   193: aload_1
    //   194: iload 15
    //   196: iload 18
    //   198: invokespecial 774	java/io/ByteArrayInputStream:<init>	([BII)V
    //   201: astore_3
    //   202: new 776	java/io/DataInputStream
    //   205: dup
    //   206: aload_3
    //   207: invokespecial 779	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   210: astore 4
    //   212: aload 9
    //   214: aload 4
    //   216: invokevirtual 782	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   219: putfield 176	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: aload_3
    //   223: astore_2
    //   224: aload 4
    //   226: astore_3
    //   227: aload_2
    //   228: ifnull +19 -> 247
    //   231: aload_3
    //   232: astore 7
    //   234: aload_2
    //   235: astore 8
    //   237: aload_3
    //   238: astore 4
    //   240: aload_2
    //   241: astore 5
    //   243: aload_2
    //   244: invokevirtual 783	java/io/ByteArrayInputStream:close	()V
    //   247: aload_3
    //   248: ifnull +19 -> 267
    //   251: aload_3
    //   252: astore 7
    //   254: aload_2
    //   255: astore 8
    //   257: aload_3
    //   258: astore 4
    //   260: aload_2
    //   261: astore 5
    //   263: aload_3
    //   264: invokevirtual 784	java/io/DataInputStream:close	()V
    //   267: iload 14
    //   269: iconst_1
    //   270: iadd
    //   271: istore 14
    //   273: iload 15
    //   275: iload 18
    //   277: iadd
    //   278: istore 15
    //   280: aload_2
    //   281: astore 4
    //   283: aload_3
    //   284: astore_2
    //   285: goto -160 -> 125
    //   288: iload 17
    //   290: iconst_2
    //   291: if_icmpne +174 -> 465
    //   294: new 772	java/io/ByteArrayInputStream
    //   297: dup
    //   298: aload_1
    //   299: iload 15
    //   301: iload 18
    //   303: invokespecial 774	java/io/ByteArrayInputStream:<init>	([BII)V
    //   306: astore_3
    //   307: new 776	java/io/DataInputStream
    //   310: dup
    //   311: aload_3
    //   312: invokespecial 779	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   315: astore 4
    //   317: aload 9
    //   319: aload 4
    //   321: invokevirtual 782	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   324: putfield 188	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   327: new 772	java/io/ByteArrayInputStream
    //   330: dup
    //   331: aload_1
    //   332: iload 15
    //   334: iload 18
    //   336: invokespecial 774	java/io/ByteArrayInputStream:<init>	([BII)V
    //   339: astore 6
    //   341: new 776	java/io/DataInputStream
    //   344: dup
    //   345: aload 6
    //   347: invokespecial 779	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   350: astore_3
    //   351: aload_3
    //   352: astore 7
    //   354: aload 6
    //   356: astore 8
    //   358: aload_3
    //   359: astore 4
    //   361: aload 6
    //   363: astore 5
    //   365: aload 9
    //   367: getfield 787	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_b_of_type_ArrayOfInt	[I
    //   370: iconst_0
    //   371: aload_3
    //   372: invokevirtual 790	java/io/DataInputStream:readInt	()I
    //   375: iastore
    //   376: aload_3
    //   377: astore 7
    //   379: aload 6
    //   381: astore 8
    //   383: aload_3
    //   384: astore 4
    //   386: aload 6
    //   388: astore 5
    //   390: aload 9
    //   392: getfield 787	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_b_of_type_ArrayOfInt	[I
    //   395: iconst_1
    //   396: aload_3
    //   397: invokevirtual 790	java/io/DataInputStream:readInt	()I
    //   400: iastore
    //   401: aload 6
    //   403: astore_2
    //   404: goto -177 -> 227
    //   407: astore_3
    //   408: aload 8
    //   410: astore_2
    //   411: aload 7
    //   413: astore_1
    //   414: aload_1
    //   415: astore 4
    //   417: aload_2
    //   418: astore 5
    //   420: aload_3
    //   421: invokevirtual 222	java/lang/Throwable:printStackTrace	()V
    //   424: aload_1
    //   425: astore 4
    //   427: aload_2
    //   428: astore 5
    //   430: new 91	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   433: dup
    //   434: invokespecial 92	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   437: astore 6
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 783	java/io/ByteArrayInputStream:close	()V
    //   447: aload 6
    //   449: astore_3
    //   450: aload_1
    //   451: ifnull -414 -> 37
    //   454: aload_1
    //   455: invokevirtual 784	java/io/DataInputStream:close	()V
    //   458: aload 6
    //   460: areturn
    //   461: astore_1
    //   462: aload 6
    //   464: areturn
    //   465: iload 17
    //   467: iconst_3
    //   468: if_icmpeq +9 -> 477
    //   471: iload 17
    //   473: iconst_4
    //   474: if_icmpne +302 -> 776
    //   477: new 772	java/io/ByteArrayInputStream
    //   480: dup
    //   481: aload_1
    //   482: iload 15
    //   484: iload 18
    //   486: invokespecial 774	java/io/ByteArrayInputStream:<init>	([BII)V
    //   489: astore_3
    //   490: new 776	java/io/DataInputStream
    //   493: dup
    //   494: aload_3
    //   495: invokespecial 779	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   498: astore 4
    //   500: aload 4
    //   502: invokevirtual 790	java/io/DataInputStream:readInt	()I
    //   505: istore 19
    //   507: aload 4
    //   509: invokevirtual 782	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   512: astore_2
    //   513: iload 17
    //   515: iconst_3
    //   516: if_icmpne +30 -> 546
    //   519: aload 9
    //   521: getfield 157	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   524: new 194	ConfigPush/FileStorageServerListInfo
    //   527: dup
    //   528: aload_2
    //   529: iload 19
    //   531: invokespecial 791	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   534: invokevirtual 399	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload_3
    //   539: astore_2
    //   540: aload 4
    //   542: astore_3
    //   543: goto -316 -> 227
    //   546: aload 9
    //   548: getfield 166	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   551: new 194	ConfigPush/FileStorageServerListInfo
    //   554: dup
    //   555: aload_2
    //   556: iload 19
    //   558: invokespecial 791	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   561: invokevirtual 399	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   564: pop
    //   565: aload_3
    //   566: astore_2
    //   567: aload 4
    //   569: astore_3
    //   570: goto -343 -> 227
    //   573: aload 4
    //   575: astore_3
    //   576: aload_2
    //   577: astore 6
    //   579: aload 9
    //   581: astore_2
    //   582: aload_3
    //   583: ifnull +7 -> 590
    //   586: aload_3
    //   587: invokevirtual 783	java/io/ByteArrayInputStream:close	()V
    //   590: aload_2
    //   591: astore_3
    //   592: aload 6
    //   594: ifnull -557 -> 37
    //   597: aload 6
    //   599: invokevirtual 784	java/io/DataInputStream:close	()V
    //   602: aload_2
    //   603: areturn
    //   604: astore_1
    //   605: aload_2
    //   606: areturn
    //   607: astore_1
    //   608: aload 5
    //   610: astore_3
    //   611: aload 4
    //   613: astore_2
    //   614: aload_3
    //   615: ifnull +7 -> 622
    //   618: aload_3
    //   619: invokevirtual 783	java/io/ByteArrayInputStream:close	()V
    //   622: aload_2
    //   623: ifnull +7 -> 630
    //   626: aload_2
    //   627: invokevirtual 784	java/io/DataInputStream:close	()V
    //   630: aload_1
    //   631: athrow
    //   632: astore_2
    //   633: goto -3 -> 630
    //   636: astore_1
    //   637: aload 4
    //   639: astore_2
    //   640: goto -26 -> 614
    //   643: astore_1
    //   644: aload 4
    //   646: astore_2
    //   647: goto -33 -> 614
    //   650: astore_1
    //   651: aload 4
    //   653: astore_2
    //   654: aload 6
    //   656: astore_3
    //   657: goto -43 -> 614
    //   660: astore_1
    //   661: aload 4
    //   663: astore_2
    //   664: goto -50 -> 614
    //   667: astore_1
    //   668: aload 4
    //   670: astore_3
    //   671: goto -57 -> 614
    //   674: astore_1
    //   675: goto -61 -> 614
    //   678: astore_1
    //   679: goto -65 -> 614
    //   682: astore_1
    //   683: goto -69 -> 614
    //   686: astore_1
    //   687: aload_3
    //   688: astore_2
    //   689: aload_1
    //   690: astore_3
    //   691: aload 4
    //   693: astore_1
    //   694: goto -280 -> 414
    //   697: astore 5
    //   699: aload 4
    //   701: astore_1
    //   702: aload_3
    //   703: astore_2
    //   704: aload 5
    //   706: astore_3
    //   707: goto -293 -> 414
    //   710: astore_3
    //   711: aload 4
    //   713: astore_1
    //   714: aload 6
    //   716: astore_2
    //   717: goto -303 -> 414
    //   720: astore_1
    //   721: aload_3
    //   722: astore_2
    //   723: aload_1
    //   724: astore_3
    //   725: aload 4
    //   727: astore_1
    //   728: goto -314 -> 414
    //   731: astore_3
    //   732: aload_2
    //   733: astore_1
    //   734: aload 4
    //   736: astore_2
    //   737: goto -323 -> 414
    //   740: astore 4
    //   742: aload_2
    //   743: astore_1
    //   744: aload_3
    //   745: astore_2
    //   746: aload 4
    //   748: astore_3
    //   749: goto -335 -> 414
    //   752: astore 4
    //   754: aload_2
    //   755: astore_1
    //   756: aload_3
    //   757: astore_2
    //   758: aload 4
    //   760: astore_3
    //   761: goto -347 -> 414
    //   764: astore 4
    //   766: aload_2
    //   767: astore_1
    //   768: aload_3
    //   769: astore_2
    //   770: aload 4
    //   772: astore_3
    //   773: goto -359 -> 414
    //   776: aload_2
    //   777: astore_3
    //   778: aload 4
    //   780: astore_2
    //   781: goto -554 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	FMTSrvAddrProvider
    //   0	784	1	paramArrayOfByte	byte[]
    //   41	586	2	localObject1	Object
    //   632	1	2	localThrowable1	Throwable
    //   639	142	2	localObject2	Object
    //   36	361	3	localObject3	Object
    //   407	14	3	localThrowable2	Throwable
    //   449	258	3	localObject4	Object
    //   710	12	3	localThrowable3	Throwable
    //   724	1	3	arrayOfByte	byte[]
    //   731	14	3	localThrowable4	Throwable
    //   748	30	3	localObject5	Object
    //   19	716	4	localObject6	Object
    //   740	7	4	localThrowable5	Throwable
    //   752	7	4	localThrowable6	Throwable
    //   764	15	4	localThrowable7	Throwable
    //   1	608	5	localObject7	Object
    //   697	8	5	localThrowable8	Throwable
    //   44	671	6	localObject8	Object
    //   55	357	7	localObject9	Object
    //   59	350	8	localObject10	Object
    //   7	573	9	localPttIpList	FMTSrvAddrProvider.PttIpList
    //   16	69	10	localObject11	Object
    //   4	93	11	localObject12	Object
    //   13	80	12	localObject13	Object
    //   10	55	13	localObject14	Object
    //   115	157	14	i	int
    //   118	365	15	j	int
    //   112	18	16	k	int
    //   136	381	17	m	int
    //   168	317	18	n	int
    //   505	52	19	i1	int
    // Exception table:
    //   from	to	target	type
    //   79	84	407	java/lang/Throwable
    //   100	109	407	java/lang/Throwable
    //   243	247	407	java/lang/Throwable
    //   263	267	407	java/lang/Throwable
    //   365	376	407	java/lang/Throwable
    //   390	401	407	java/lang/Throwable
    //   443	447	461	java/lang/Throwable
    //   454	458	461	java/lang/Throwable
    //   586	590	604	java/lang/Throwable
    //   597	602	604	java/lang/Throwable
    //   79	84	607	finally
    //   100	109	607	finally
    //   243	247	607	finally
    //   263	267	607	finally
    //   365	376	607	finally
    //   390	401	607	finally
    //   420	424	607	finally
    //   430	439	607	finally
    //   618	622	632	java/lang/Throwable
    //   626	630	632	java/lang/Throwable
    //   212	222	636	finally
    //   317	341	643	finally
    //   341	351	650	finally
    //   500	513	660	finally
    //   519	538	660	finally
    //   546	565	660	finally
    //   144	157	667	finally
    //   163	183	667	finally
    //   189	202	667	finally
    //   294	307	667	finally
    //   477	490	667	finally
    //   202	212	674	finally
    //   307	317	678	finally
    //   490	500	682	finally
    //   212	222	686	java/lang/Throwable
    //   317	341	697	java/lang/Throwable
    //   341	351	710	java/lang/Throwable
    //   500	513	720	java/lang/Throwable
    //   519	538	720	java/lang/Throwable
    //   546	565	720	java/lang/Throwable
    //   144	157	731	java/lang/Throwable
    //   163	183	731	java/lang/Throwable
    //   189	202	731	java/lang/Throwable
    //   294	307	731	java/lang/Throwable
    //   477	490	731	java/lang/Throwable
    //   202	212	740	java/lang/Throwable
    //   307	317	752	java/lang/Throwable
    //   490	500	764	java/lang/Throwable
  }
  
  /* Error */
  public ServerAddr a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 316	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:c	(I)Ljava/util/ArrayList;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +52 -> 61
    //   12: aload_3
    //   13: invokevirtual 163	java/util/ArrayList:size	()I
    //   16: ifle +45 -> 61
    //   19: new 794	com/tencent/mobileqq/transfile/ServerAddr
    //   22: dup
    //   23: invokespecial 795	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokevirtual 192	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: checkcast 194	ConfigPush/FileStorageServerListInfo
    //   36: getfield 204	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   39: putfield 796	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 192	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 194	ConfigPush/FileStorageServerListInfo
    //   51: getfield 197	ConfigPush/FileStorageServerListInfo:iPort	I
    //   54: putfield 798	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: areturn
    //   61: aconst_null
    //   62: astore_2
    //   63: goto -6 -> 57
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	FMTSrvAddrProvider
    //   0	71	1	paramInt	int
    //   26	37	2	localServerAddr	ServerAddr
    //   66	4	2	localObject	Object
    //   7	37	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	8	66	finally
    //   12	57	66	finally
  }
  
  public StructLongMessageIpSaver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileStructLongMessageIpSaver;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = c(paramInt);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ArrayList a(byte[] paramArrayOfByte)
  {
    Object localObject = new ptt_apply.QQApplyAuthkeyRsp();
    try
    {
      ((ptt_apply.QQApplyAuthkeyRsp)localObject).mergeFrom(paramArrayOfByte);
      if (((ptt_apply.QQApplyAuthkeyRsp)localObject).address.has())
      {
        paramArrayOfByte = ((ptt_apply.QQApplyAuthkeyRsp)localObject).address.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = new ArrayList();
          int i = 0;
          while (i < paramArrayOfByte.size())
          {
            ptt_apply.Addr localAddr = (ptt_apply.Addr)paramArrayOfByte.get(i);
            int j = localAddr.uint32_out_ip.get();
            if (j != 0)
            {
              int k = localAddr.uint32_out_port.get();
              ((ArrayList)localObject).add(new FileStorageServerListInfo(a(j), k));
            }
            i += 1;
          }
          return (ArrayList)localObject;
        }
      }
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "FMT SERVER LIST CLEARED!!!");
      }
      ArrayList localArrayList1 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      ArrayList localArrayList2 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
      localFileStoragePushFSSvcList.vC2CPicDownList = localArrayList1;
      localFileStoragePushFSSvcList.vGPicDownLoadList = localArrayList2;
      localFileStoragePushFSSvcList.pttlist = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist;
      a(localFileStoragePushFSSvcList);
      this.jdField_a_of_type_Vas.a();
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      this.jdField_b_of_type_JavaUtilHashtable.clear();
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList = localArrayList1;
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList = localArrayList2;
      this.h = 2;
      d();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 16) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.a(this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver.b(), paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "onFailed for GroupPtt: " + paramString);
        }
        return;
      }
      finally {}
      this.jdField_a_of_type_Vas.a(paramInt, paramString);
    }
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "set svclist" + paramFileStoragePushFSSvcList);
      }
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      this.h = 1;
      d();
      c(paramFileStoragePushFSSvcList);
      return;
    }
    finally {}
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length != 0) {
          break label86;
        }
        return false;
      }
      catch (Throwable paramArrayOfByte) {}
      if (i < k)
      {
        j += 1;
        byte[] arrayOfByte = new byte[2];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 2);
        j = j + 2 + Utils.a(arrayOfByte, 0);
        if (j <= paramArrayOfByte.length) {
          i += 1;
        }
      }
      else
      {
        i = paramArrayOfByte.length;
        if (j == i) {
          return bool;
        }
        bool = false;
        continue;
      }
      label86:
      while (paramArrayOfByte[0] != 0) {
        return false;
      }
      int k = paramArrayOfByte[1];
      int j = 2;
      int i = 0;
    }
  }
  
  /* Error */
  public byte[] a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 844	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 847	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    String str = this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList != null)
    {
      if (!bool) {
        break label58;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.jdField_a_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      return a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList);
      label58:
      this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.jdField_b_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider$PttIpList.jdField_b_of_type_JavaLangString = str;
    }
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf b()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null)
        {
          localObject1 = localObject3;
          if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf.length > 0)
          {
            localObject1 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf;
            localObject2 = new subcmd0x501.RspBody();
          }
        }
      }
    }
    try
    {
      ((subcmd0x501.RspBody)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject2).msg_subcmd_0x501_rsp_body.get()).msg_download_encrypt_conf;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            QLog.d("FMT_ADDR", 2, "picEncryptSwitchInit: pic:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypted_pic.get() + ",url:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypt_request.get() + ",ctlFlg:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).uint32_ctrl_flag.get());
            localObject1 = localObject2;
          }
        }
      }
      return (subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localObject2 = null;
      }
    }
  }
  
  public String b()
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Vas.a();
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return (String)localObject1;
    }
    finally {}
  }
  
  public String b(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Vas.a(paramInt);
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return (String)localObject1;
    }
    finally {}
  }
  
  /* Error */
  public ArrayList b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_Vas	Lvas;
    //   6: iload_1
    //   7: invokevirtual 875	vas:a	(I)Ljava/util/ArrayList;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +94 -> 106
    //   15: new 159	java/util/ArrayList
    //   18: dup
    //   19: aload_3
    //   20: invokevirtual 163	java/util/ArrayList:size	()I
    //   23: invokespecial 876	java/util/ArrayList:<init>	(I)V
    //   26: astore_2
    //   27: iconst_0
    //   28: istore 6
    //   30: iload 6
    //   32: aload_3
    //   33: invokevirtual 163	java/util/ArrayList:size	()I
    //   36: if_icmpge +66 -> 102
    //   39: aload_3
    //   40: iload 6
    //   42: invokevirtual 192	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   45: checkcast 194	ConfigPush/FileStorageServerListInfo
    //   48: astore 4
    //   50: new 878	vbk
    //   53: dup
    //   54: invokespecial 879	vbk:<init>	()V
    //   57: astore 5
    //   59: aload 5
    //   61: aload 4
    //   63: getfield 204	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   66: putfield 880	vbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload 5
    //   71: aload 4
    //   73: getfield 197	ConfigPush/FileStorageServerListInfo:iPort	I
    //   76: putfield 881	vbk:b	I
    //   79: aload 5
    //   81: iload_1
    //   82: putfield 883	vbk:jdField_a_of_type_Int	I
    //   85: aload_2
    //   86: iload 6
    //   88: aload 5
    //   90: invokevirtual 886	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   93: iload 6
    //   95: iconst_1
    //   96: iadd
    //   97: istore 6
    //   99: goto -69 -> 30
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: areturn
    //   106: aconst_null
    //   107: astore_2
    //   108: goto -6 -> 102
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	FMTSrvAddrProvider
    //   0	116	1	paramInt	int
    //   26	82	2	localArrayList1	ArrayList
    //   111	4	2	localObject	Object
    //   10	30	3	localArrayList2	ArrayList
    //   48	24	4	localFileStorageServerListInfo	FileStorageServerListInfo
    //   57	32	5	localvbk	vbk
    //   28	70	6	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	111	finally
    //   15	27	111	finally
    //   30	93	111	finally
  }
  
  public void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "setSvcListCache" + paramFileStoragePushFSSvcList);
      }
      this.jdField_b_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      return;
    }
    finally {}
  }
  
  /* Error */
  public byte[] b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 844	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 373	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 891	ConfigPush/BigDataChannel:sBigdata_key_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPttIpSaver.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileStructLongMessageIpSaver.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\FMTSrvAddrProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */