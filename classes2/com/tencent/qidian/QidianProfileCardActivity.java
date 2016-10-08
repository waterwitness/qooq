package com.tencent.qidian;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.GroupItem;
import com.tencent.qidian.data.PublicAccountItem;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigGroupInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import wyh;
import wyi;
import wyj;
import wyk;
import wyl;
import wym;
import wyn;
import wyo;
import wyp;
import wyq;
import wyr;
import wys;
import wyt;
import wyu;
import wyv;
import wyw;
import wyz;
import wzc;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public static final String a = "QidianProfileCardActivity";
  private static final String jdField_b_of_type_JavaLangString = "message/rfc822";
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BmqqBusinessObserver jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public FriendsManager a;
  public BmqqUserSimpleInfo a;
  public ProfileCardInfo a;
  private MQQProfileName jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver;
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public ConcurrentHashMap a;
  private wzc jdField_a_of_type_Wzc;
  public int b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  public ConcurrentHashMap b;
  public int c;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  private TextView d;
  int e;
  
  public QidianProfileCardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wyv(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new wyw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wyi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new wyl(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new wym(this);
    this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver = new wyn(this);
  }
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if (paramURLDrawable != null)
    {
      Bitmap localBitmap;
      if ((paramURLDrawable instanceof BitmapDrawable))
      {
        localBitmap = ((BitmapDrawable)paramURLDrawable).getBitmap();
        paramURLDrawable = localBitmap;
        if (paramBoolean) {
          paramURLDrawable = paramQQAppInterface.a(localBitmap, 50, 50);
        }
      }
      do
      {
        do
        {
          return paramURLDrawable;
          if (!(paramURLDrawable instanceof SkinnableBitmapDrawable)) {
            break;
          }
          localBitmap = ((SkinnableBitmapDrawable)paramURLDrawable).getBitmap();
          paramURLDrawable = localBitmap;
        } while (!paramBoolean);
        return paramQQAppInterface.a(localBitmap, 50, 50);
        localBitmap = ImageUtil.a(paramURLDrawable);
        paramURLDrawable = localBitmap;
      } while (!paramBoolean);
      return paramQQAppInterface.a(localBitmap, 50, 50);
    }
    return null;
  }
  
  public static Message a(Parcelable paramParcelable)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramParcelable);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message a(ArrayList paramArrayList)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("data", paramArrayList);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    paramInt2 = getResources().getDimensionPixelSize(2131492995);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131301921);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = paramInt2;
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localButton;
  }
  
  private DataTag a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      return null;
    case 1: 
      return new DataTag(52, paramString2);
    case 2: 
      return new DataTag(4, paramString2);
    case 3: 
      return new DataTag(47, paramString2);
    case 4: 
      return new DataTag(48, new String[] { paramString1, paramString2 });
    }
    return new DataTag(54, paramString3);
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
        return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName)) {
        return this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName;
      }
      return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private String a(String paramString)
  {
    Object localObject2 = null;
    Friends localFriends = null;
    Object localObject1 = localFriends;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) {
        break label27;
      }
      localObject1 = localFriends;
    }
    label27:
    do
    {
      do
      {
        return (String)localObject1;
        localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(paramString);
        paramString = (String)localObject2;
        if (localFriends != null)
        {
          paramString = (String)localObject2;
          if (localFriends.remark != null) {
            paramString = localFriends.remark;
          }
        }
        localObject1 = paramString;
      } while (!TextUtils.isEmpty(paramString));
      localObject1 = paramString;
    } while (localFriends == null);
    return localFriends.name;
  }
  
  private void a(QidianProfileUiInfo.ConfigGroupInfo paramConfigGroupInfo)
  {
    paramConfigGroupInfo = paramConfigGroupInfo.a;
    if (paramConfigGroupInfo != null)
    {
      int j = paramConfigGroupInfo.size();
      int i = 0;
      if (i < j)
      {
        QidianProfileUiInfo.ConfigInfo localConfigInfo = (QidianProfileUiInfo.ConfigInfo)paramConfigGroupInfo.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localConfigInfo, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (paramConfigInfo != null) {}
    switch (paramConfigInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramConfigInfo, paramBoolean);
      return;
    case 2: 
      c(paramConfigInfo, paramBoolean);
      return;
    }
    d(paramConfigInfo, paramBoolean);
  }
  
  private void b(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if ((paramConfigInfo.jdField_b_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramConfigInfo.jdField_b_of_type_JavaLangString.trim()))) {
      return;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = paramConfigInfo.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = paramConfigInfo.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = paramConfigInfo.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(paramConfigInfo.jdField_d_of_type_JavaLangString))
    {
      str = paramConfigInfo.jdField_d_of_type_JavaLangString;
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = str;
      if (localQidianSimpleProfileItem.jdField_b_of_type_Int == 0) {
        break label144;
      }
    }
    label144:
    for (boolean bool = true;; bool = false)
    {
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool;
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = paramConfigInfo.jdField_a_of_type_Boolean;
      paramConfigInfo = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Wzc.sendMessage(paramConfigInfo);
      return;
      str = paramConfigInfo.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  private void c(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      PublicAccountItem localPublicAccountItem = (PublicAccountItem)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_d_of_type_Int = localPublicAccountItem.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localPublicAccountItem.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localPublicAccountItem.jdField_b_of_type_JavaLangString.trim();
      if (localPublicAccountItem.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.jdField_d_of_type_JavaLangString = localPublicAccountItem.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localPublicAccountItem.jdField_d_of_type_JavaLangString;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    paramConfigInfo = a(localArrayList);
    this.jdField_a_of_type_Wzc.sendMessage(paramConfigInfo);
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 4) {
      a(2131364484);
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
  }
  
  private void d(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GroupItem localGroupItem = (GroupItem)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_d_of_type_Int = paramConfigInfo.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localGroupItem.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localGroupItem.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    paramConfigInfo = a(localArrayList);
    this.jdField_a_of_type_Wzc.sendMessage(paramConfigInfo);
  }
  
  private void e(int paramInt)
  {
    this.jdField_a_of_type_Wzc.postDelayed(new wyp(this, paramInt), 1000L);
  }
  
  private void f(int paramInt)
  {
    int i = 1;
    Object localObject2 = "";
    Object localObject1;
    String str;
    if (paramInt == 1) {
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname))
        {
          localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
          localObject2 = localObject1;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job)) {
            break label280;
          }
          localObject2 = new StringBuilder();
          if ((this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo.corpName))) {
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo.corpName).append(" ");
          }
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job);
          str = ((StringBuilder)localObject2).toString();
          if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 1) {
            break label178;
          }
          paramInt = i;
          label133:
          localObject2 = localObject1;
          localObject1 = str;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramInt != 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.uin;
        break;
        label178:
        paramInt = 0;
        break label133;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        paramInt = 0;
        localObject1 = "";
        continue;
        if ((paramInt != 0) && (paramInt != 2)) {
          break label280;
        }
        localObject1 = a();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle))) {
          break label265;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle;
        localObject2 = localObject1;
        paramInt = 0;
        localObject1 = str;
        continue;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
      label265:
      str = "";
      localObject2 = localObject1;
      paramInt = 0;
      localObject1 = str;
      continue;
      label280:
      paramInt = 0;
      localObject1 = "";
    }
  }
  
  private void g(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.getConfigGroupInfos().iterator();
        while (localIterator.hasNext()) {
          a((QidianProfileUiInfo.ConfigGroupInfo)localIterator.next());
        }
      }
    }
    else if ((paramInt == 0) || (paramInt == 2)) {
      j();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = null;
    this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = null;
    this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = null;
  }
  
  private void i()
  {
    Resources localResources = getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131492908) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301066));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298449));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301058));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wyq(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297886));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301060));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131297613));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new wyr(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296829));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301059));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296821));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301064));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131367975));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new wys(this));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301065));
    this.jdField_d_of_type_AndroidWidgetTextView.setTag(new DataTag(53, null));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b();
  }
  
  private void i(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, 4, paramString);
    FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void j()
  {
    QidianProfileUiInfo.ConfigGroupInfo localConfigGroupInfo;
    QidianProfileUiInfo.ConfigInfo localConfigInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localConfigGroupInfo = new QidianProfileUiInfo.ConfigGroupInfo();
      localConfigGroupInfo.a = new ArrayList(5);
      new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 2;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131371238);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131367567);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 3;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131368860);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131371657);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!BmqqSegmentUtil.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!BmqqSegmentUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label432;
      }
      localConfigInfo.jdField_b_of_type_Int = 7;
      localConfigInfo.jdField_d_of_type_JavaLangString = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 0;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131367467);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localConfigGroupInfo.a.add(localConfigInfo);
      a(localConfigGroupInfo);
      return;
      label432:
      localConfigInfo.jdField_b_of_type_Int = 0;
    }
  }
  
  private void k()
  {
    ThreadManager.b(new wyu(this));
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable1 == null) || (localURLDrawable1.getStatus() == 2)) {
        return ImageUtil.b();
      }
    }
    catch (Exception localException)
    {
      URLDrawable localURLDrawable2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAFaceDrawable load net error, " + localException.getMessage());
        }
        localURLDrawable2 = null;
      }
      if (localURLDrawable2.getStatus() == 1) {
        return new BitmapDrawable(a(this.app, localURLDrawable2, true));
      }
      paramURLImageView.setURLDrawableDownListener(new wyz(this, this.app, paramURLImageView, paramString, ImageUtil.b(), true));
      return localURLDrawable2;
    }
  }
  
  public View a(QidianProfileCardActivity.QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2130904038, null);
    TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131301070);
    TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131301071);
    ImageView localImageView1 = (ImageView)localRelativeLayout.findViewById(2131301073);
    ImageView localImageView2 = (ImageView)localRelativeLayout.findViewById(2131301072);
    localTextView1.setText(paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString);
    localTextView2.setText(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
    if (!paramQidianSimpleProfileItem.jdField_a_of_type_Boolean)
    {
      localImageView1.setVisibility(4);
      localRelativeLayout.setLongClickable(true);
      localRelativeLayout.setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    while (paramQidianSimpleProfileItem.jdField_c_of_type_Boolean)
    {
      localImageView2.setVisibility(0);
      return localRelativeLayout;
      localRelativeLayout.setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView1.setVisibility(0);
    }
    localImageView2.setVisibility(8);
    return localRelativeLayout;
  }
  
  public View a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      localObject1 = null;
    }
    LinearLayout localLinearLayout;
    int i;
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return (View)localObject1;
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2130904037, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131296792);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131300057);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2130904036, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131296790);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131296829);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131296793);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131301068);
    localURLImageView.post(new wyt(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_d_of_type_Int == 0)
    {
      localTextView2.setText(2131361801);
      ((LinearLayout)localObject1).setTag(new DataTag(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label242:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_d_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label387;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130839503);
    }
    for (;;)
    {
      localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
      if (i == 0) {
        ((LinearLayout)localObject1).setPadding(0, 0, this.e, 0);
      }
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      i += 1;
      break;
      if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_d_of_type_Int == 1)
      {
        localTextView2.setText(2131361802);
        ((LinearLayout)localObject1).setTag(new DataTag(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label242;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new DataTag(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label242;
      label387:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_d_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130840444);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492908));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, URLImageView paramURLImageView, String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    for (;;)
    {
      return;
      if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
      {
        paramURLImageView.setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
        return;
      }
      Object localObject;
      if (paramInt == 0) {
        localObject = FaceDrawable.a(this.app, 1, paramString);
      }
      while (localObject != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
        if (paramInt == 1) {
          localObject = a(paramURLImageView, paramString);
        } else {
          localObject = this.app.a(paramString);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131230786)[0], 1);
      if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_ComTencentWidgetActionSheet.c(super.getResources().getStringArray(2131230786)[1]);
      }
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d(super.getResources().getStringArray(2131230786)[2]);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new wyj(this, paramString));
    }
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianProfileCardActivity", 2, "enterNewPage content is null");
      }
      return;
    }
    Intent localIntent = new Intent(this, QidianProfileAllTextActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    super.startActivity(localIntent);
  }
  
  public boolean a()
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_b_of_type_Int);
    }
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      bool = false;
      return bool;
      a(2131364484);
      return true;
      CrmUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, true);
    }
  }
  
  public Drawable b(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable1 == null) || (localURLDrawable1.getStatus() == 2)) {
        return ImageUtil.b();
      }
    }
    catch (Exception localException)
    {
      URLDrawable localURLDrawable2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAQrDrawable load net error, " + localException.getMessage());
        }
        localURLDrawable2 = null;
      }
      if (localURLDrawable2.getStatus() == 1) {
        return new BitmapDrawable(a(this.app, localURLDrawable2, false));
      }
      paramURLImageView.setURLDrawableDownListener(new wyz(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130843491), false));
      return localURLDrawable2;
    }
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2) && (this.jdField_b_of_type_Int != 0)) {}
    label195:
    label227:
    for (;;)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if (this.jdField_b_of_type_Int == 1)
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131369990, 2130904315, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(7, null));
        }
        if ((this.jdField_b_of_type_Int != 1) || (!this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label195;
        }
        a(2131361805, 2130904315, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label227;
        }
        a(2131371178, 2130904288, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(8, null));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        if (bool3) {
          a(2131370025, 2130904315, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    EntityManager localEntityManager;
    if (paramInt == 1) {
      localEntityManager = this.app.a().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.a(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.a(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localEntityManager.a(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.a();
        }
      }
      if ((paramInt != 0) && (paramInt != 2)) {
        continue;
      }
      localEntityManager = this.app.a().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.a();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131230785)[0], 1);
      if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131230785)[1], 1);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131230785)[2], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(super.getResources().getStringArray(2131230785)[3]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new wyk(this, paramString));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    this.jdField_a_of_type_Wzc.sendMessage(localMessage);
  }
  
  public void c(int paramInt)
  {
    f(paramInt);
    g(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "Show finish");
    }
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    PublicAccountUtil.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    localIntent.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    localIntent.addFlags(536870912);
    super.startActivityForResult(localIntent, 1012);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, 2130904040, null, null, getString(2131369134), getString(2131369134), new wyo(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(super.getString(2131361804));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(true);
    }
    paramString = b((URLImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.framePreviewImage, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(paramString, true, 1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1012: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          super.finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
      } while (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
      i(paramIntent);
      return;
    }
    super.setResult(-1);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card start " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.app.getManager(164));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    setContentView(2130904035);
    this.jdField_c_of_type_Int = AIOUtils.a(16.0F, getResources());
    this.jdField_d_of_type_Int = AIOUtils.a(10.0F, getResources());
    this.e = AIOUtils.a(8.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
    {
      super.finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a()))) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
    h();
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    this.app.a(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Wzc = new wzc(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.a(new wyh(this), 8, null, true);
    d(this.jdField_b_of_type_Int);
    i();
    k();
    e(this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card end " + System.currentTimeMillis());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.b(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.b(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    h();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131370024, 1);
      return;
    }
    CrmUtils.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    ChatSettingForTroop.a(this, TroopInfoActivity.a(paramString, 31), 2);
  }
  
  public void f()
  {
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void f(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void g()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  public void g(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    }
  }
  
  public void h(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\QidianProfileCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */