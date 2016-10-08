package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import vbf;
import vbg;

public class OldHttpEngine$OldHttpCommunicatorListner
  implements IHttpCommunicatorListener
{
  int jdField_a_of_type_Int;
  public HttpNetReq a;
  public NetResp a;
  public HttpMsg a;
  public OutputStream a;
  public RandomAccessFile a;
  String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  int d;
  int e;
  
  public OldHttpEngine$OldHttpCommunicatorListner(OldHttpEngine paramOldHttpEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 5;
    this.d = 0;
    this.e = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Long = System.currentTimeMillis();
        if (NetworkCenter.a().a() == 0) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
        {
          ThreadManager.a().schedule(new vbf(this), paramLong);
          return;
        }
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        ThreadManager.a().schedule(new vbg(this), paramLong);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    NetResp localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localHttpNetReq != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localHttpNetReq.b == null) || (localOutputStream == null)) {}
    }
    try
    {
      localOutputStream.close();
      if (localRandomAccessFile == null) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localRandomAccessFile.close();
        if (localNetResp != null)
        {
          if ((localHttpNetReq.jdField_e_of_type_JavaLangString != null) && (localNetResp.e != 3)) {
            OldHttpEngine.a(this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine).remove(localHttpNetReq.jdField_e_of_type_JavaLangString);
          }
          if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localHttpNetReq.o;
              if (localHttpNetReq.c != 1) {
                break label221;
              }
              RichMediaUtil.a(i, bool, localHttpNetReq.n, localHttpNetReq.jdField_d_of_type_JavaLangString, "onOutEngine", "result:" + localNetResp.e + " errCode:" + localNetResp.jdField_f_of_type_Int + " desc:" + localNetResp.jdField_a_of_type_JavaLangString);
            }
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(localNetResp);
          }
        }
        a();
        return;
        localIOException2 = localIOException2;
        localIOException2.printStackTrace();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
          continue;
          label221:
          bool = false;
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = OldHttpEngine.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HttpNetReq localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    if (localHttpNetReq != null) {
      localHttpNetReq.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    label302:
    label394:
    label457:
    label562:
    label588:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Int = 0;
        } while (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == null);
        Object localObject1;
        int i;
        for (;;)
        {
          try
          {
            if ((paramHttpMsg2.c() != 206) && (paramHttpMsg2.c() != 200)) {
              break;
            }
            paramHttpMsg1 = paramHttpMsg2.a();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder;
            localObject1 = paramHttpMsg1;
            if (localObject2 == null) {}
          }
          catch (IOException paramHttpMsg1)
          {
            paramHttpMsg1.printStackTrace();
            this.jdField_a_of_type_Boolean = true;
            a(paramHttpMsg1, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
            throw new RuntimeException("io exceptionmsg:" + paramHttpMsg1.getMessage());
          }
          try
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder.a(paramHttpMsg1);
            if (localObject1 == null) {
              break;
            }
            i = localObject1.length;
            if (i <= 0) {
              break;
            }
            paramHttpMsg1 = (HttpMsg)localObject1;
            if (localObject1.length <= 0) {
              break label588;
            }
            paramHttpMsg1 = (HttpMsg)localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$AESDecryptor == null) {
              break label588;
            }
            l1 = System.nanoTime();
            i = 1;
            paramHttpMsg1 = null;
          }
          catch (Throwable paramHttpMsg1)
          {
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            throw new RuntimeException("FlowDecoderExp:" + paramHttpMsg1.substring(0, Math.min(100, paramHttpMsg1.length())));
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$AESDecryptor.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label302;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException paramHttpMsg1)
          {
            int j;
            byte[] arrayOfByte;
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label457;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalLen=" + paramHttpMsg2.a());
            paramHttpMsg1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalLen=" + paramHttpMsg2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException paramHttpMsg1)
          {
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException paramHttpMsg1)
          {
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException paramHttpMsg1)
          {
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            i = 0;
            continue;
          }
          catch (BadPaddingException paramHttpMsg1)
          {
            paramHttpMsg1 = Log.getStackTraceString(paramHttpMsg1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
            paramHttpMsg1.jdField_j_of_type_Long = (l2 - l1 + paramHttpMsg1.jdField_j_of_type_Long);
            paramHttpMsg1 = (HttpMsg)localObject1;
          }
          if (i != 0) {
            break label562;
          }
          throw new RuntimeException("DecryptError:" + paramHttpMsg1);
          if ((paramHttpMsg2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c != paramHttpMsg2.a())) {
            break label394;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += paramHttpMsg1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = paramHttpMsg2.a();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long = paramHttpMsg2.jdField_b_of_type_Long;
        paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        l1 = paramHttpMsg2.c;
        paramHttpMsg2.c = (paramHttpMsg1.length + l1);
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener == null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(paramHttpMsg2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(paramHttpMsg1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = paramHttpMsg2.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long = paramHttpMsg2.jdField_b_of_type_Long;
      paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
      long l1 = paramHttpMsg2.c;
      paramHttpMsg2.c = (paramHttpMsg1.length + l1);
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener == null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = paramHttpMsg2.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long = paramHttpMsg2.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte = paramHttpMsg2.a();
  }
  
  void a(IOException paramIOException, NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      paramNetResp = paramIOException.getMessage();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301, paramNetResp + MsfSdkUtils.getStackTraceString(paramIOException), null);
      paramIOException = Environment.getExternalStorageState();
      if (paramNetResp.contains("EACCES"))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
        return;
      }
      if ((paramNetResp.contains("ENOSPC")) || (paramNetResp.contains("space")))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9040;
        return;
      }
      if (paramNetResp.contains("Read-only"))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_g_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
      paramString.jdField_j_of_type_Int += 1;
    }
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      b(paramHttpMsg2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a()) {
        break label770;
      }
      if ((a(paramHttpMsg2)) && (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c != this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder == null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder.a()))) {
        break label420;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.e = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_e_of_type_Boolean) && (paramInt == 0) && (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b))) {
        FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b);
      }
    }
    catch (Exception paramHttpMsg2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_d_of_type_Boolean) {
          break label240;
        }
      }
      catch (IOException paramHttpMsg2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_e_of_type_Boolean) {
              break;
            }
            if (paramHttpMsg1.e != 0L) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_h_of_type_Long = paramHttpMsg1.e;
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.i = paramHttpMsg1.jdField_h_of_type_Long;
            if (paramHttpMsg1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_j_of_type_Long = paramHttpMsg1.jdField_f_of_type_Long;
            }
            c();
            return true;
            paramHttpMsg2 = paramHttpMsg2;
            paramHttpMsg2.printStackTrace();
          }
          paramHttpMsg2 = paramHttpMsg2;
          paramHttpMsg2.printStackTrace();
        }
        catch (IOException paramHttpMsg2)
        {
          for (;;)
          {
            paramHttpMsg2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!FileUtils.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b))) {
              if (FileUtils.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.b != null) {}
    label420:
    label613:
    label770:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.o;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.c != 1) {
              break label613;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            RichMediaUtil.a(paramInt, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_d_of_type_JavaLangString, "check", "writtenSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 56009, null, null);
            paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.e = 1;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9058;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.o) + "." + RichMediaUtil.c(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n), 1, "id:" + String.valueOf(paramHttpMsg1.ai) + "reqUrl:" + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString + ",reqHeader:" + paramHttpMsg1.ak + "responseHeader:" + paramHttpMsg2.al);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.e = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long == 0L)));
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 56009, null, null);
    paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
    paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      paramHttpMsg2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.d = NetworkCenter.a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    NetResp localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    if ((localObject == null) || (localNetResp == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label340:
    int i;
    if (((HttpNetReq)localObject).b != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((HttpNetReq)localObject).b, ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString);
          localNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label340;
          }
          l = localFile.length();
          if ((l <= 0L) || (((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix == null)) {
            continue;
          }
          localNetResp.c = l;
          ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a((NetReq)localObject, localNetResp);
          if (!((HttpNetReq)localObject).jdField_d_of_type_Boolean) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((HttpNetReq)localObject).jdField_a_of_type_Long);
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + l);
          }
        }
        catch (IOException localIOException)
        {
          File localFile;
          long l;
          localIOException.printStackTrace();
          this.jdField_b_of_type_Boolean = true;
          a(localIOException, localException);
          continue;
          if (!((HttpNetReq)localObject).jdField_d_of_type_Boolean) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + l + " trunk");
          continue;
          this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
          continue;
        }
        try
        {
          localObject = new URL(((HttpNetReq)localObject).jdField_a_of_type_JavaLangString).getHost();
          localNetResp.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localFile, true);
      }
      if (QLog.isColorLevel())
      {
        i = ((HttpNetReq)localObject).o;
        if (((HttpNetReq)localObject).c != 1) {
          break label451;
        }
      }
    }
    label451:
    for (boolean bool = true;; bool = false)
    {
      RichMediaUtil.a(i, bool, ((HttpNetReq)localObject).n, ((HttpNetReq)localObject).jdField_d_of_type_JavaLangString, "createtmp", this.jdField_a_of_type_JavaLangString);
      FileUtils.a(this.jdField_a_of_type_JavaLangString);
      if (((HttpNetReq)localObject).jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((HttpNetReq)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((HttpNetReq)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  void b(HttpMsg paramHttpMsg)
  {
    NetResp localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localNetResp == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localNetResp.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.containsKey(HttpMsg.am)) {
      localHashMap1.put("netresp_param_reason", paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.get(HttpMsg.am));
    }
    localNetResp.jdField_a_of_type_JavaUtilHashMap.clear();
    localNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(paramHttpMsg.jdField_b_of_type_JavaUtilHashMap);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramHttpMsg.al);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramHttpMsg.ak);
    localNetResp.jdField_g_of_type_Int = paramHttpMsg.c();
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    HttpNetReq localHttpNetReq;
    NetResp localNetResp;
    do
    {
      return;
      localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
      localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    } while ((localHttpNetReq == null) || (localNetResp == null));
    b(paramHttpMsg2);
    long l1 = System.currentTimeMillis() - localNetResp.jdField_f_of_type_Long;
    localNetResp.jdField_d_of_type_Long += l1;
    if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0)).b();
    }
    long l2 = NetworkCenter.a().a();
    int j;
    if (l2 != 0L) {
      j = 1;
    }
    for (;;)
    {
      int i;
      label154:
      label275:
      label300:
      int k;
      boolean bool1;
      label344:
      label406:
      boolean bool2;
      if ((localNetResp.jdField_f_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.c;
        this.c = (i - 1);
        if (i > 0)
        {
          if ((localNetResp.jdField_f_of_type_Int == 9056) || (localNetResp.jdField_f_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label763;
          }
          localNetResp.jdField_f_of_type_Int = paramHttpMsg2.jdField_h_of_type_Int;
          localNetResp.jdField_a_of_type_JavaLangString = paramHttpMsg2.aj;
          localNetResp.e = 1;
          if (j == 0)
          {
            localNetResp.jdField_f_of_type_Int = 9004;
            localNetResp.jdField_a_of_type_JavaLangString = "no network";
            localNetResp.e = 1;
          }
          if ((l2 == this.d) || (l2 == 0L) || (this.d == 0L)) {
            break label768;
          }
          i = 1;
          if ((!localHttpNetReq.f) || (i == 0) || (!RichMediaStrategy.a(paramHttpMsg2.jdField_h_of_type_Int))) {
            break label774;
          }
          i = 1;
          if (i != 0)
          {
            localNetResp.jdField_f_of_type_Int = 9364;
            localNetResp.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localHttpNetReq.o;
              if (localHttpNetReq.c != 1) {
                break label780;
              }
              bool1 = true;
              RichMediaUtil.a(k, bool1, localHttpNetReq.n, localHttpNetReq.jdField_d_of_type_JavaLangString, "netChg", "originNet:" + this.d + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label786;
          }
          bool1 = true;
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || (!paramHttpMsg2.d()) || (((localNetResp.jdField_d_of_type_Long >= localHttpNetReq.jdField_d_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localHttpNetReq.k)) && ((!bool1) || (localNetResp.jdField_d_of_type_Long >= localHttpNetReq.jdField_d_of_type_Long * 3L / 2L - 5000L)))) {
            break label1204;
          }
          if (QLog.isColorLevel())
          {
            i = localHttpNetReq.o;
            if (localHttpNetReq.c != 1) {
              break label792;
            }
            bool2 = true;
            label506:
            RichMediaUtil.a(i, bool2, localHttpNetReq.n, localHttpNetReq.jdField_d_of_type_JavaLangString, "retry", "tryTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_h_of_type_Int + " consumeTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Long + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localNetResp.c > 0L)
          {
            if (!localHttpNetReq.c()) {
              break label804;
            }
            if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix == null) {
              break label798;
            }
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
            this.jdField_a_of_type_JavaIoOutputStream = localHttpNetReq.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label632:
          k = i;
          if (localHttpNetReq.h)
          {
            k = i;
            if (paramHttpMsg2.c() >= 400)
            {
              k = i;
              if (paramHttpMsg2.c() <= 424)
              {
                i = 0;
                k = i;
                if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
              }
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        try
        {
          FileUtils.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception paramHttpMsg2)
        {
          for (;;)
          {
            label763:
            label768:
            label774:
            label780:
            label786:
            label792:
            label798:
            label804:
            k = i;
          }
        }
        if (this.e >= localHttpNetReq.l) {
          localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          c();
          return;
          j = 0;
          continue;
          if (j == 0) {
            break label154;
          }
          this.jdField_a_of_type_Int += 1;
          break label154;
          c();
          return;
          i = 0;
          break label275;
          i = 0;
          break label300;
          bool1 = false;
          break label344;
          bool1 = false;
          break label406;
          bool2 = false;
          break label506;
          i = 0;
          break label632;
          i = k;
          if (!localHttpNetReq.b()) {
            break label632;
          }
          if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix != null)
          {
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
            i = k;
            break label632;
          }
          k = 0;
          i = k;
          if (this.jdField_a_of_type_JavaIoOutputStream == null) {
            break label632;
          }
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream.close();
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
            localNetResp.c = 0L;
            i = 1;
          }
          catch (IOException localIOException)
          {
            a(localIOException, localNetResp);
            i = k;
          }
          break label632;
        }
        if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder != null) {
          localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder.a();
        }
        if (localHttpNetReq.jdField_a_of_type_Boolean)
        {
          InnerDns.a().a(InnerDns.a(localHttpNetReq.jdField_a_of_type_JavaLangString), InnerDns.a(paramHttpMsg1.a()), 1002);
          localHttpNetReq.jdField_a_of_type_Boolean = false;
        }
        if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.remove(0);
          localHttpNetReq.jdField_a_of_type_JavaUtilList.add(paramHttpMsg1);
          paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0);
          paramHttpMsg2 = "http://" + paramHttpMsg1.jdField_a_of_type_JavaLangString;
          if (paramHttpMsg1.jdField_b_of_type_Int != 80)
          {
            paramHttpMsg1 = paramHttpMsg2 + ":" + paramHttpMsg1.jdField_b_of_type_Int + "/";
            localHttpNetReq.jdField_a_of_type_JavaLangString = RichMediaUtil.a(localHttpNetReq.jdField_a_of_type_JavaLangString, paramHttpMsg1);
          }
        }
        else
        {
          if ((localNetResp.jdField_f_of_type_Int == 9050) && (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam != null)) {
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.a(this.jdField_a_of_type_Int);
          }
          if ((localNetResp.jdField_f_of_type_Int != 9056) || (l2 == 0L)) {
            break label1181;
          }
          l1 = 0L;
        }
        for (;;)
        {
          a(l1);
          return;
          paramHttpMsg1 = paramHttpMsg2 + "/";
          break;
          label1181:
          if (l2 != 0L) {
            l1 = 3000L;
          } else {
            l1 = 6000L;
          }
        }
        label1204:
        c();
        return;
      }
      catch (Exception paramHttpMsg2)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\OldHttpEngine$OldHttpCommunicatorListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */