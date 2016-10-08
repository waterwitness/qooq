package com.weiyun.sdk.context;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.weiyun.sdk.IWySender;
import com.weiyun.sdk.WyConfiguration;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.channel.SenderHelper;
import com.weiyun.sdk.log.ILogger;

public class SdkContext
{
  private static final String KEY_PWD_HAS = "key_pwd_has";
  private static final String KEY_PWD_QUERIED = "key_pwd_queried";
  private static final String KEY_PWD_VERIFIED = "key_pwd_verified";
  private static final String SHARE_PREF_NAME = "weiyun_pwd_cokiee";
  private static SdkContext sInstance = new SdkContext();
  private String mAccount;
  private WyConfiguration mConfigure;
  private Context mContext;
  private IndependentPasswordContext mIPContext = new IndependentPasswordContext();
  private ILogger mLogger;
  private ISender mSender;
  private long mUin;
  
  public static void cleanCokiee(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("weiyun_pwd_cokiee", 0).edit();
    paramContext.remove("key_pwd_queried" + paramLong);
    paramContext.remove("key_pwd_has" + paramLong);
    paramContext.remove("key_pwd_verified" + paramLong);
    paramContext.commit();
  }
  
  public static SdkContext getInstance()
  {
    return sInstance;
  }
  
  public String getAccount()
  {
    return this.mAccount;
  }
  
  public WyConfiguration getConfigure()
  {
    return this.mConfigure;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public IndependentPasswordContext getIPContext()
  {
    return this.mIPContext;
  }
  
  public ILogger getLogger()
  {
    return this.mLogger;
  }
  
  public ISender getSender()
  {
    return this.mSender;
  }
  
  public SharedPreferences getSharedPreferences()
  {
    if (this.mContext != null) {
      return this.mContext.getSharedPreferences("weiyun_pwd_cokiee", 0);
    }
    return null;
  }
  
  public long getUin()
  {
    return this.mUin;
  }
  
  public void init()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = SdkContext.this.getSharedPreferences();
        if ((paramAnonymousVarArgs != null) && (!SdkContext.IndependentPasswordContext.access$100(SdkContext.this.mIPContext)))
        {
          boolean bool1 = paramAnonymousVarArgs.getBoolean("key_pwd_queried" + SdkContext.this.mUin, false);
          boolean bool2 = paramAnonymousVarArgs.getBoolean("key_pwd_has" + SdkContext.this.mUin, false);
          boolean bool3 = paramAnonymousVarArgs.getBoolean("key_pwd_verified" + SdkContext.this.mUin, false);
          SdkContext.access$002(SdkContext.this, new SdkContext.IndependentPasswordContext(bool1, bool2, bool3));
        }
        return null;
      }
    }.execute(new Void[0]);
  }
  
  public boolean isDebug()
  {
    return this.mConfigure.isDebugModel();
  }
  
  public void setAccount(String paramString, long paramLong)
  {
    this.mAccount = paramString;
    this.mUin = paramLong;
  }
  
  public void setConfigure(WyConfiguration paramWyConfiguration)
  {
    this.mConfigure = paramWyConfiguration;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setLogger(ILogger paramILogger)
  {
    this.mLogger = paramILogger;
  }
  
  public void setSender(IWySender paramIWySender)
  {
    this.mSender = new SenderHelper(paramIWySender);
  }
  
  public void unInit()
  {
    Object localObject = getSharedPreferences();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_pwd_queried" + this.mUin);
      ((SharedPreferences.Editor)localObject).remove("key_pwd_has" + this.mUin);
      ((SharedPreferences.Editor)localObject).remove("key_pwd_verified" + this.mUin);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.mIPContext = new IndependentPasswordContext();
    localObject = this.mSender;
    if (localObject != null) {
      ((ISender)localObject).releaseSender();
    }
  }
  
  public static class IndependentPasswordContext
  {
    private volatile boolean mIsLastUpdated = false;
    private volatile boolean mIsQueried;
    private volatile boolean mIsVerifySuccess;
    private volatile boolean mhasIndependentPassword;
    
    public IndependentPasswordContext()
    {
      this.mIsQueried = false;
      this.mhasIndependentPassword = false;
      this.mIsVerifySuccess = false;
    }
    
    public IndependentPasswordContext(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.mIsQueried = paramBoolean1;
      this.mhasIndependentPassword = paramBoolean2;
      this.mIsVerifySuccess = paramBoolean3;
    }
    
    public boolean hasIndependentPassword()
    {
      return this.mhasIndependentPassword;
    }
    
    public boolean isQueried()
    {
      return this.mIsQueried;
    }
    
    public boolean isVerifySuccess()
    {
      return this.mIsVerifySuccess;
    }
    
    public void setHasIndependentPassword()
    {
      this.mIsLastUpdated = true;
      this.mhasIndependentPassword = true;
      SharedPreferences localSharedPreferences = SdkContext.getInstance().getSharedPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("key_pwd_has" + SdkContext.getInstance().getUin(), true).commit();
      }
    }
    
    public void setQueried()
    {
      this.mIsLastUpdated = true;
      this.mIsQueried = true;
      SharedPreferences localSharedPreferences = SdkContext.getInstance().getSharedPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("key_pwd_queried" + SdkContext.getInstance().getUin(), true).commit();
      }
    }
    
    public void setVerifySuccess()
    {
      this.mIsLastUpdated = true;
      this.mIsVerifySuccess = true;
      SharedPreferences localSharedPreferences = SdkContext.getInstance().getSharedPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("key_pwd_verified" + SdkContext.getInstance().getUin(), true).commit();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\context\SdkContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */