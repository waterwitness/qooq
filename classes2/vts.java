import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class vts
  extends TroopFeedViewFactory.ViewProvider
{
  public vts(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2130903878, null);
    }
    vtt localvtt = (vtt)localView3.getTag();
    if (localvtt == null)
    {
      localvtt = new vtt(this);
      localvtt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131299762));
      localvtt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131297123));
      localvtt.b = ((TextView)localView3.findViewById(2131297013));
      localvtt.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131300541));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localvtt);
    }
    for (;;)
    {
      localvtt.jdField_a_of_type_Int = paramInt;
      localvtt.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localvtt.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localvtt.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localvtt.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localvtt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localvtt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localvtt.b.setVisibility(0);
      localvtt.b.setSingleLine(false);
      localvtt.b.setMaxLines(2);
      localvtt.b.setText("");
      localvtt.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localvtt.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839777);
        }
        paramView = this.a.b;
        if (StringUtil.b(paramTroopFeedItem.picPath)) {
          break label1145;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = AIOUtils.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          Object localObject;
          if ((!paramTroopFeedItem.isStoryType()) && (paramTroopFeedItem.type == 5) && (paramTroopFeedItem.type == 19))
          {
            localObject = str;
            if (paramTroopFeedItem.type == 99) {}
          }
          else
          {
            paramView = str;
            if (!StringUtil.b(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localvtt.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296932)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!StringUtil.b(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = " 发表于 " + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localvtt.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300542)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localvtt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localvtt.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + "两指向左横向滑动查看下一条通知";
                }
                localView3.setContentDescription(paramTroopFeedItem);
                return localView3;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localView2 = paramView;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + paramTroopFeedItem.feedTime);
                localView2 = paramView;
              }
              if (paramTroopFeedItem.type == 132)
              {
                if (this.a.c == null) {
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839779);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839777);
              }
              paramView = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          View localView2;
          paramInt = 0;
          continue;
          if ((paramTroopFeedItem.type == 5) || (paramTroopFeedItem.type == 19))
          {
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localvtt.b.setText(paramTroopFeedItem.content);
            localvtt.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localvtt.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839782);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839781);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localvtt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localvtt.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals("群日历"))
          {
            localvtt.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localvtt.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
          }
          paramView = localView2 + " " + paramTroopFeedItem.content;
          continue;
        }
        label1145:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */