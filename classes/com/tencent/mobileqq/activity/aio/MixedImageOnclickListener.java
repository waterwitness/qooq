package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;

public class MixedImageOnclickListener
  implements View.OnClickListener
{
  private long a;
  public SessionInfo a;
  
  public MixedImageOnclickListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    URLImageView localURLImageView;
    MessageForPic localMessageForPic;
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
        localURLImageView = (URLImageView)paramView;
        localMessageForPic = (MessageForPic)localURLImageView.getTag(2131296342);
        localURLDrawable = (URLDrawable)localURLImageView.getDrawable();
        switch (localURLDrawable.getStatus())
        {
        default: 
          return;
        }
      } while (localURLDrawable.isDownloadStarted());
      localURLDrawable.startDownload();
      return;
    } while (!FileUtils.a(paramView.getContext()));
    localURLDrawable.restartDownload();
    return;
    PicItemBuilder.a(paramView.getContext(), localURLImageView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\MixedImageOnclickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */