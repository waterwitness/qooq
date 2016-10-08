package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class YellowTipsLayout
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String AD_LEVEL_INFO = "info";
  public static final String AD_LEVEL_WARNING = "warning";
  public static final String KEY_HB_AD = "mk_hb_ad";
  public static final String KEY_TRANS_AD = "transfer_ad";
  private ImageView mArrowView;
  private TextView mText;
  private String mUrl;
  private ImageView mWariningView;
  
  public YellowTipsLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    init(paramContext);
  }
  
  public YellowTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public static JSONObject getYellowTipsConfig(Context paramContext, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    paramContext = new File(paramContext.getFilesDir().getPath() + "/QWallet/" + paramString + "/hbThemeConfig.cfg");
    StringBuilder localStringBuilder;
    if (paramContext.exists()) {
      try
      {
        paramContext = new FileInputStream(paramContext);
        paramString = new byte['Ѐ'];
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          int i = paramContext.read(paramString);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new String(paramString, 0, i));
        }
        return localJSONObject;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext.close();
    paramContext = new JSONObject(new String(Base64.decode(localStringBuilder.toString(), 0)));
    return paramContext;
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903871, this, true);
    paramContext.setClickable(true);
    paramContext.setOnClickListener(this);
    this.mWariningView = ((ImageView)findViewById(2131300530));
    this.mText = ((TextView)findViewById(2131300531));
    this.mArrowView = ((ImageView)findViewById(2131300532));
  }
  
  public void onClick(View paramView)
  {
    if (this.mUrl != null)
    {
      Intent localIntent = new Intent();
      paramView = paramView.getContext();
      localIntent.setClass(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", this.mUrl);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.startActivity(localIntent);
    }
  }
  
  public void setArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mArrowView.getVisibility() != 0) {
        this.mArrowView.setVisibility(0);
      }
    }
    while (this.mArrowView.getVisibility() != 0) {
      return;
    }
    this.mArrowView.setVisibility(4);
  }
  
  public void setMessage(String paramString)
  {
    this.mText.setText(paramString);
  }
  
  public void setUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setArrowVisible(false);
      this.mUrl = null;
      return;
    }
    setArrowVisible(true);
    this.mUrl = paramString;
  }
  
  public void setWarningVisible(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mWariningView.getVisibility() != 0) {
        this.mWariningView.setVisibility(0);
      }
    }
    while (this.mWariningView.getVisibility() != 0) {
      return;
    }
    this.mWariningView.setVisibility(4);
  }
  
  public boolean setYellowTipsJsonConfig(JSONObject paramJSONObject, String paramString)
  {
    setVisibility(8);
    if (paramJSONObject == null) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          Object localObject = paramJSONObject.optJSONObject(paramString);
          if (localObject != null)
          {
            paramJSONObject = ((JSONObject)localObject).optString("ad_text");
            paramString = ((JSONObject)localObject).optString("ad_url");
            String str1 = ((JSONObject)localObject).optString("ad_level");
            String str2 = ((JSONObject)localObject).optString("ad_begin_time");
            localObject = ((JSONObject)localObject).optString("ad_end_time");
            if ((!TextUtils.isEmpty(paramJSONObject)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str2)))
            {
              SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              long l1 = localSimpleDateFormat.parse(str2).getTime();
              long l2 = localSimpleDateFormat.parse((String)localObject).getTime();
              long l3 = System.currentTimeMillis();
              if ((l3 >= l1) && (l3 <= l2))
              {
                setVisibility(0);
                this.mText.setText(paramJSONObject);
                setUrl(paramString);
                set_ad_level(str1);
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
          }
        }
      }
    } while (getVisibility() != 0);
    return true;
  }
  
  public void set_ad_level(String paramString)
  {
    if ((paramString != null) && ("info".equals(paramString)))
    {
      setWarningVisible(false);
      return;
    }
    setWarningVisible(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\widget\YellowTipsLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */