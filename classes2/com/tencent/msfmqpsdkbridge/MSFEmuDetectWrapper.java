package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.secsrv.MQPEmuDetectService;
import com.tencent.mqpsdk.secsrv.MQPEmuDetectService.IEmuDetectResultListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

public class MSFEmuDetectWrapper
  implements MQPEmuDetectService.IEmuDetectResultListener
{
  private static final byte jdField_a_of_type_Byte = 18;
  private boolean jdField_a_of_type_Boolean;
  
  public MSFEmuDetectWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(BaseApplication.getContext().getFilesDir(), "QPfile");
      if (((File)localObject).exists())
      {
        localObject = new File((File)localObject, paramString);
        if (((File)localObject).exists()) {
          for (;;)
          {
            try
            {
              paramString = new ByteArrayOutputStream();
            }
            catch (Exception localException1)
            {
              byte[] arrayOfByte;
              int j;
              int i;
              paramString = null;
            }
            for (;;)
            {
              try
              {
                localObject = new DataInputStream(new FileInputStream((File)localObject));
                arrayOfByte = new byte['Ѐ'];
                if (((DataInputStream)localObject).available() != 0)
                {
                  j = ((DataInputStream)localObject).read(arrayOfByte);
                  if (j >= 0) {}
                }
                else
                {
                  ((DataInputStream)localObject).close();
                  if (paramString == null) {
                    continue;
                  }
                }
              }
              catch (Exception localException2)
              {
                continue;
              }
              try
              {
                paramString.close();
                paramString = new String(paramString.toByteArray(), "UTF-8");
                return paramString;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
            i = 0;
            if (i < j)
            {
              paramString.write((byte)(arrayOfByte[i] ^ 0x12));
              i += 1;
            }
            else
            {
              continue;
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    return null;
  }
  
  public static boolean a()
  {
    boolean bool = true;
    File localFile = new File(BaseApplication.getContext().getFilesDir(), "QPfile");
    if (localFile.exists()) {
      bool = localFile.delete();
    }
    return bool;
  }
  
  public int a(String paramString)
  {
    Object localObject = new File(BaseApplication.getContext().getFilesDir(), "QPfile");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = a(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        paramString.put("emu_detect_config", localObject);
        if (paramString == null) {
          break label130;
        }
        paramString = paramString.toString();
        localObject = new MQPSecServiceManager(BaseApplication.getContext().getApplicationContext(), null);
        if (localObject != null)
        {
          localObject = (MQPEmuDetectService)((MQPSecServiceManager)localObject).a("emu_detect");
          if (localObject != null)
          {
            ((MQPEmuDetectService)localObject).a(this);
            ((MQPEmuDetectService)localObject).a(paramString);
          }
        }
        if (this.a) {
          return 1;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      return 3;
      label130:
      paramString = (String)localObject;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("emu_detect_result"))
        {
          this.a = paramString.getBoolean("emu_detect_result");
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\msfmqpsdkbridge\MSFEmuDetectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */