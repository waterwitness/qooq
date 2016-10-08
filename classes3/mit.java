import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class mit
  extends AccountObserver
{
  public mit(RegisterPhoneNumActivity paramRegisterPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.onRegQueryAccountResp isSuccess=" + paramBoolean + " code=" + paramInt);
    }
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject;
    if (!paramBoolean)
    {
      this.a.d();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localObject = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          localObject = this.a.getString(2131368479);
        }
        this.a.a((String)localObject, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        int i;
        int j;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegQueryAccountResp code = " + paramInt + ";strMsg = " + paramArrayOfByte);
          }
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            i = paramArrayOfByte.indexOf("(");
            j = paramArrayOfByte.indexOf(")");
            if ((i > 0) && (j > 0) && (i + 1 < j)) {
              RegisterPhoneNumActivity.a(this.a, paramArrayOfByte.substring(i + 1, j));
            }
          }
          switch (paramInt)
          {
          case 4: 
          default: 
            this.a.d();
            localObject = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              localObject = this.a.getResources().getString(2131368479);
            }
            this.a.a((String)localObject, 1);
            return;
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localException1 = localException1;
        paramArrayOfByte = null;
      }
      continue;
      RegisterPhoneNumActivity.b(this.a, false);
      RegisterPhoneNumActivity.a(this.a, null);
      return;
      this.a.d();
      RegisterPhoneNumActivity.b(this.a, true);
      RegisterPhoneNumActivity.a(this.a, null);
      return;
      this.a.d();
      RegisterVerifyCodeActivity.a(this.a.app, this.a, this.a.d, this.a.e, this.a.f, "");
      this.a.finish();
      return;
      this.a.d();
      RegisterVerifyCodeActivity.a(this.a.app, this.a, this.a.d, this.a.e, this.a.f, "");
      this.a.finish();
      return;
      this.a.d();
      RegisterPhoneNumActivity.b(this.a, true);
      RegisterPhoneNumActivity.c(this.a, false);
      RegisterPhoneNumActivity.a(this.a, null);
      return;
      paramArrayOfByte = null;
    }
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegisterCommitMobileResp");
    }
    if (paramArrayOfByte1 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte2 = new String(paramArrayOfByte1, "utf-8");
        byte[] arrayOfByte1 = paramArrayOfByte2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onRegisterCommitMobileResp code = " + paramInt + ";strMsg = " + paramArrayOfByte2);
            arrayOfByte1 = paramArrayOfByte2;
          }
          if (!this.a.isFinishing()) {
            break label110;
          }
          return;
        }
        catch (Exception localException2)
        {
          byte[] arrayOfByte2;
          for (;;) {}
        }
        localException1 = localException1;
        paramArrayOfByte2 = null;
      }
      arrayOfByte2 = paramArrayOfByte2;
      continue;
      label110:
      if (paramInt != 3) {
        this.a.d();
      }
      if (!paramBoolean)
      {
        paramArrayOfByte1 = arrayOfByte2;
        if (TextUtils.isEmpty(arrayOfByte2)) {
          paramArrayOfByte1 = this.a.getString(2131368479);
        }
        this.a.a(paramArrayOfByte1, 1);
        return;
      }
      switch (paramInt)
      {
      default: 
        this.a.a(2131368479, 1);
        return;
      case 0: 
        this.a.a(0, 0L);
        return;
      case 2: 
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          if ((TextUtils.isEmpty(paramArrayOfByte1)) || (TextUtils.isEmpty(paramArrayOfByte1)))
          {
            this.a.a(2131368479, 1);
            return;
          }
        }
        catch (Exception paramArrayOfByte1)
        {
          for (;;)
          {
            paramArrayOfByte1.printStackTrace();
            paramArrayOfByte1 = null;
          }
          RegisterPhoneNumActivity.b(this.a, paramArrayOfByte1);
          return;
        }
      case 1: 
        this.a.a(0, 0L);
        return;
      case 3: 
        try
        {
          paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          if (TextUtils.isEmpty(paramArrayOfByte1))
          {
            this.a.a(2131368479, 1);
            return;
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte1)
        {
          for (;;)
          {
            paramArrayOfByte1.printStackTrace();
            paramArrayOfByte1 = (byte[])localObject;
          }
          RegisterPhoneNumActivity.c(this.a, paramArrayOfByte1);
          this.a.d();
          return;
        }
      }
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
        if (!TextUtils.isEmpty(paramArrayOfByte1))
        {
          this.a.b.post(new miu(this, paramArrayOfByte1));
          return;
        }
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RegisterPhoneNumActivity", 2, "captcha url is empty");
        return;
        paramArrayOfByte2 = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */