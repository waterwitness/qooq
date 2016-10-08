import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.util.List;

public class tna
  implements Runnable
{
  public tna(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, FreshNewsInfo paramFreshNewsInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    int j = (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a * 55.0F + 0.5D);
    int k = NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).getMeasuredWidth();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getResources().getDrawable(2130841004);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = j;
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent))
    {
      k = Math.min(k / j, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size());
      if (i < k)
      {
        str = (String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(i);
        if (!TextUtils.isEmpty(str))
        {
          if ((str.endsWith(".jpg")) || (str.endsWith(".png")) || (!str.startsWith("http://p.qpic.cn/fresh_news/"))) {
            break label865;
          }
          str = str + "250";
        }
      }
    }
    Object localObject5;
    Object localObject2;
    label865:
    for (;;)
    {
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localURLImageView.setLayoutParams(new LinearLayout.LayoutParams(j, j));
      ((ViewGroup.MarginLayoutParams)localURLImageView.getLayoutParams()).rightMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a * 5.0F + 0.5D));
      Object localObject3 = null;
      localObject1 = null;
      try
      {
        localObject5 = URLDrawable.getDrawable(NearbyImgDownloader.a(str), localURLDrawableOptions);
        localObject1 = localObject5;
        localObject3 = localObject5;
        ((URLDrawable)localObject5).setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a, "actProfileCardFreshNewsEntryPicDownload"));
        localObject1 = localObject5;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        for (;;)
        {
          QLog.d("NearbyProfileDisplayPanel", 1, "setFreshNewsInfo IllegalArgumentException url=" + str);
        }
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        for (;;)
        {
          QLog.d("NearbyProfileDisplayPanel", 1, "setFreshNewsInfo MalforemedURLException url=" + str);
          localObject2 = localIllegalArgumentException1;
          continue;
          localURLImageView.setImageResource(2130840689);
        }
      }
      if (localObject1 != null)
      {
        localURLImageView.setImageDrawable((Drawable)localObject1);
        NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).addView(localURLImageView);
        i += 1;
        break;
      }
      if (AppSetting.j) {
        NearbyProfileDisplayPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).setContentDescription("新鲜事 " + k + "张图片");
      }
      do
      {
        return;
        Object localObject4 = (String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(0);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject4).endsWith(".jpg"))
          {
            localObject2 = localObject4;
            if (!((String)localObject4).endsWith(".png"))
            {
              localObject2 = localObject4;
              if (((String)localObject4).startsWith("http://p.qpic.cn/fresh_news/")) {
                localObject2 = (String)localObject4 + "250";
              }
            }
          }
          localObject5 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a);
          ((ImageView)localObject5).setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((ImageView)localObject5).setLayoutParams(new LinearLayout.LayoutParams(j, j));
        }
        try
        {
          localObject4 = URLDrawable.getDrawable(NearbyImgDownloader.a((String)localObject2), localURLDrawableOptions);
          localObject2 = localObject4;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          for (;;)
          {
            QLog.d("NearbyProfileDisplayPanel", 1, "setFreshNewsInfo IllegalArgumentException url=" + (String)localObject2);
            localObject2 = null;
          }
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          for (;;)
          {
            QLog.d("NearbyProfileDisplayPanel", 1, "setFreshNewsInfo MalformedURLException url=" + (String)localObject2);
            localObject2 = null;
            continue;
            ((ImageView)localObject5).setImageResource(2130840689);
          }
        }
        if (localObject2 == null) {
          break;
        }
        ((ImageView)localObject5).setImageDrawable((Drawable)localObject2);
        NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).addView((View)localObject5);
        localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a);
        ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
        i = (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.a * 10.0F + 0.5D);
        ((TextView)localObject2).setPadding(i, 0, i, 0);
        ((TextView)localObject2).setTextSize(1, 16.0F);
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a.getResources().getColor(2131428262));
        ((TextView)localObject2).setMaxLines(2);
        ((TextView)localObject2).setGravity(16);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent, 3, 16));
        NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).addView((View)localObject2);
      } while (!AppSetting.j);
      NearbyProfileDisplayPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).setContentDescription("新鲜事 一张图片 " + NearbyProfileDisplayPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel).freshNewsInfo.feedContent);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */