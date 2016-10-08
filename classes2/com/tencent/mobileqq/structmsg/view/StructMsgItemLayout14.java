package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import uwi;

public class StructMsgItemLayout14
  extends AbsStructMsgItem
  implements View.OnClickListener
{
  public static String[] a;
  public static final String o = "StructMsgItemLayout14";
  private QQAppInterface a;
  public MessageForTroopTopic a;
  private ArrayList b = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "picture", "content", "title" };
  }
  
  public StructMsgItemLayout14()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic = null;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new uwi(this, paramContext);
    paramContext.setOrientation(1);
    paramContext.setGravity(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(AIOUtils.a(13.0F, localResources), 0, AIOUtils.a(13.0F, localResources), 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131296563);
    return paramContext;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected int b()
  {
    return 14;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout14 getView start.");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((FragmentActivity)paramContext).getChatFragment().a();
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    int m;
    int n;
    int i1;
    int i;
    label139:
    int j;
    label247:
    int k;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localLinearLayout.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message instanceof MessageForTroopTopic))) {
        break label1031;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic = ((MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
      this.b.clear();
      m = paramContext.getResources().getDisplayMetrics().widthPixels - 40 - 48;
      n = m * 400 / 666;
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i >= i1) {
        break label1031;
      }
      localObject = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      ((AbsStructMsgElement)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      paramView = new LinearLayout.LayoutParams(-1, -2);
      if (!(localObject instanceof StructMsgItemTitle)) {
        break label335;
      }
      localObject = (TextView)((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextSize(0, AIOUtils.a(18.0F, localResources));
      ((TextView)localObject).setTextColor(Color.parseColor("#000000"));
      if (i != 0) {
        break label317;
      }
      j = AIOUtils.a(-3.0F, localResources);
      if (i != i1 - 1) {
        break label329;
      }
      k = AIOUtils.a(-3.0F, localResources);
      label265:
      paramView.setMargins(AIOUtils.a(2.0F, localResources), j, AIOUtils.a(2.0F, localResources), k);
      ((TextView)localObject).setLayoutParams(paramView);
      localLinearLayout.addView((View)localObject);
    }
    label317:
    label329:
    label335:
    label363:
    label424:
    label474:
    label515:
    label527:
    label536:
    do
    {
      i += 1;
      break label139;
      localLinearLayout = a(paramContext);
      break;
      j = AIOUtils.a(10.0F, localResources);
      break label247;
      k = 0;
      break label265;
      if ((localObject instanceof StructMsgItemContent))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand)
        {
          ((StructMsgItemContent)localObject).d(Integer.MAX_VALUE);
          localObject = (TextView)((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
          ((TextView)localObject).setTextSize(0, AIOUtils.a(16.0F, localResources));
          ((TextView)localObject).setLineSpacing(3.5F, 1.0F);
          ((TextView)localObject).setTextColor(Color.parseColor("#333333"));
          ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
          if (i != 0) {
            break label515;
          }
          j = 0;
          paramView.setMargins(AIOUtils.a(2.0F, localResources), j, AIOUtils.a(2.0F, localResources), 0);
          ((TextView)localObject).setLayoutParams(paramView);
          localLinearLayout.addView((View)localObject);
          paramView = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
          if (i != 0) {
            break label527;
          }
          j = -6;
          if (i != i1 - 1) {
            break label536;
          }
        }
        for (k = -6;; k = paramView.bottomMargin)
        {
          paramView.topMargin = j;
          paramView.bottomMargin = k;
          break;
          ((StructMsgItemContent)localObject).d(15);
          break label363;
          j = AIOUtils.a(10.0F, localResources);
          break label424;
          j = paramView.topMargin;
          break label474;
        }
      }
    } while (!(localObject instanceof StructMsgItemCover));
    StructMsgItemCover localStructMsgItemCover = (StructMsgItemCover)localObject;
    Object localObject = new AnyScaleTypeImageView(paramContext);
    ((AnyScaleTypeImageView)localObject).setAdjustViewBounds(true);
    label600:
    label619:
    ColorDrawable localColorDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand)
    {
      ((AnyScaleTypeImageView)localObject).setDisplayRuleDef(null);
      ((AnyScaleTypeImageView)localObject).setScaleType(ImageView.ScaleType.FIT_START);
      paramView = null;
      if (TextUtils.isEmpty(localStructMsgItemCover.o)) {
        break label968;
      }
      paramView = localStructMsgItemCover.o;
      if ((localStructMsgItemCover.i == 0) || (localStructMsgItemCover.j == 0) || (TextUtils.isEmpty(paramView))) {
        break label986;
      }
      this.b.add(paramView);
      localColorDrawable = new ColorDrawable(-1249807);
      k = localStructMsgItemCover.i;
      j = localStructMsgItemCover.j;
      if (localStructMsgItemCover.i <= m) {
        break label1049;
      }
      j = m * j / k;
      k = m;
    }
    label784:
    label968:
    label986:
    label1018:
    label1031:
    label1049:
    for (;;)
    {
      paramView = URLDrawable.getDrawable(paramView, k, j, localColorDrawable, localColorDrawable);
      paramView.setAutoDownload(true);
      if ((paramView != null) && (paramView.getStatus() == 2)) {
        paramView.restartDownload();
      }
      ((AnyScaleTypeImageView)localObject).setImageDrawable(paramView);
      paramView = new LinearLayout.LayoutParams(k, j);
      if (j > m * 3)
      {
        paramView.width = (k * 3 * m / j);
        paramView.height = (m * 3);
        if (paramView.height > m * 3)
        {
          paramView.width = (paramView.width * 3 * m / paramView.height);
          paramView.height = (m * 3);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand) && (i == i1 - 1) && (paramView.height > n))
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout14 getView. set image height " + n);
          }
          paramView.height = n;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isShowExpandButton = true;
        }
        paramView.gravity = 3;
        if (i != 0) {
          break label1018;
        }
      }
      for (j = 0;; j = AIOUtils.a(11.0F, localResources))
      {
        paramView.setMargins(0, j, 0, 0);
        ((AnyScaleTypeImageView)localObject).setLayoutParams(paramView);
        ((AnyScaleTypeImageView)localObject).setTag(Integer.valueOf(this.b.size() - 1));
        ((AnyScaleTypeImageView)localObject).setOnClickListener(this);
        localLinearLayout.addView((View)localObject);
        break;
        ((AnyScaleTypeImageView)localObject).setDisplayRuleDef(CustomScaleType.c);
        break label600;
        if (TextUtils.isEmpty(localStructMsgItemCover.b)) {
          break label619;
        }
        paramView = localStructMsgItemCover.b;
        break label619;
        break;
        if (k * 2 <= m) {
          break label784;
        }
        paramView.width = m;
        paramView.height = (j * m / k);
        break label784;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout14 getView end.");
      }
      return localLinearLayout;
    }
  }
  
  public String b()
  {
    return "Layout14";
  }
  
  public void onClick(View paramView)
  {
    Object localObject3 = paramView.getTag();
    if ((localObject3 instanceof Integer))
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin;
        }
      }
      paramView = paramView.getContext();
      localObject2 = new Intent(paramView, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      ((Intent)localObject2).putExtra("index", (Integer)localObject3);
      localBundle.putStringArrayList("seqNum", this.b);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", true);
      localBundle.putBoolean("is_not_show_index", false);
      localBundle.putBoolean("SHOW_MENU", true);
      localBundle.putBoolean("is_from_troop_topic", true);
      localBundle.putString("troop_uin", (String)localObject1);
      ((Intent)localObject2).putExtras(localBundle);
      paramView.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "aio_pic", 0, 0, (String)localObject1, "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */