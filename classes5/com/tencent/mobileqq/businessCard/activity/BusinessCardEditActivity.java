package com.tencent.mobileqq.businessCard.activity;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qvb;
import qvd;
import qve;
import qvf;
import qvg;
import qvh;
import qvi;
import qvj;
import qvk;
import qvl;
import qvm;
import qvn;
import qvo;
import qvp;
import qvq;
import qvr;
import qvs;
import qvt;
import qvu;
import qvv;
import qvw;

public class BusinessCardEditActivity
  extends BaseActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public static final int a = 1;
  public static final String a = "BusinessCard_EditActivity";
  public static final int b = 2;
  public static final String b = "mode_type";
  public static final int c = 0;
  public static final String c = "is_edit_mode";
  public static final int d = 1;
  public static final String d = "finish_immedia";
  public static final int e = 2;
  public static final String e = "has_local_remark";
  public static final int f = 3;
  public static final String f = "source_activity";
  public static final int g = 4;
  public static final String g = "cur_card_id";
  public static final int h = 10;
  public static final String h = "cur_card_body";
  public static final int i = 11;
  public static final String i = "cur_ocr_info";
  public static final int j = 12;
  public static final String j = "bind_phone_num";
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 15;
  public static final int n = 15;
  public static final int o = 90;
  public static final int p = 45;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public Dialog a;
  Intent jdField_a_of_type_AndroidContentIntent;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public BusinessCardManager a;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver;
  public BusinessCard a;
  CardOCRInfo jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  Button jdField_b_of_type_AndroidWidgetButton;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  Button jdField_c_of_type_AndroidWidgetButton;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  Button jdField_d_of_type_AndroidWidgetButton;
  public LinearLayout d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  TextView g;
  public String k;
  String l;
  String m;
  public int t;
  public int u;
  private int v;
  private int w;
  private int x;
  
  public BusinessCardEditActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.v = 1;
    this.w = 1;
    this.x = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.u = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new qvl(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new qvm(this);
  }
  
  private void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        localObject2 = paramBusinessCard.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramBusinessCard.mobilesNum.isEmpty())) {
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1);
      }
      if (!a())
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
        Object localObject4 = new ArrayList();
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        if (a((ArrayList)localObject4, (ArrayList)localObject3, (ArrayList)localObject2, (ArrayList)localObject1))
        {
          localObject4 = ((ArrayList)localObject4).iterator();
          Object localObject6;
          Object localObject5;
          Object localObject7;
          Object localObject8;
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (String)((Iterator)localObject4).next();
            localObject5 = LayoutInflater.from(this).inflate(2130904099, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131296790);
            localObject8 = FaceDrawable.a(this.app, 1, (String)localObject6);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131300662)).setText(ContactUtils.l(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131301386)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131301388)).setVisibility(0);
            localObject7 = new qvv(this);
            ((qvv)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject6);
            ((qvv)localObject7).jdField_b_of_type_JavaLangString = ContactUtils.l(this.app, (String)localObject6);
            ((qvv)localObject7).jdField_a_of_type_Boolean = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new qvo(this));
            localObject6 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2130904099, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131296790);
            localObject7 = FaceDrawable.a(this.app, 1, (String)localObject5);
            this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131300662);
            ((TextView)((View)localObject4).findViewById(2131301386)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131301387);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new qvv(this);
            ((qvv)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject5);
            ((qvv)localObject8).jdField_b_of_type_JavaLangString = ContactUtils.c(this.app, (String)localObject5, true);
            ((qvv)localObject8).jdField_a_of_type_Boolean = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((qvv)localObject8).jdField_b_of_type_JavaLangString);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new qvp(this));
            localObject5 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
            this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2130904099, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131296790);
            localObject5 = (TextView)((View)localObject3).findViewById(2131300662);
            localObject8 = (TextView)((View)localObject3).findViewById(2131301386);
            localObject6 = (Button)((View)localObject3).findViewById(2131301387);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            qvv localqvv = new qvv(this);
            localqvv.jdField_a_of_type_Boolean = true;
            if (localObject8 != null)
            {
              localObject7 = FaceDrawable.a(this.app, 11, ((CardMobileInfo)localObject8).d);
              this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              localqvv.jdField_a_of_type_JavaLangString = ((CardMobileInfo)localObject8).d;
            }
            for (localqvv.jdField_b_of_type_JavaLangString = ((CardMobileInfo)localObject8).c;; localqvv.jdField_b_of_type_JavaLangString = ((String)localObject7))
            {
              ((View)localObject3).setTag(localqvv);
              ((TextView)localObject5).setText(localqvv.jdField_b_of_type_JavaLangString);
              ((Button)localObject6).setTag(localqvv);
              ((Button)localObject6).setOnClickListener(new qvq(this));
              localObject4 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 70.0F));
              this.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              localqvv.jdField_a_of_type_JavaLangString = ((String)localObject7);
            }
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            a(this.jdField_d_of_type_AndroidWidgetLinearLayout, (String)localObject2, 0);
          }
        }
        a(this.jdField_d_of_type_AndroidWidgetLinearLayout, null, 0);
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301352);
      Object localObject2 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301355);
      if (!paramBusinessCard.descs.isEmpty())
      {
        ((LinearLayout)localObject1).setVisibility(0);
        ((View)localObject2).setVisibility(0);
        paramBusinessCard = paramBusinessCard.descs.iterator();
        while (paramBusinessCard.hasNext())
        {
          localObject1 = (String)paramBusinessCard.next();
          a(this.jdField_e_of_type_AndroidWidgetLinearLayout, (String)localObject1, 2);
        }
      }
      ((LinearLayout)localObject1).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
    }
  }
  
  private void a(BusinessCard paramBusinessCard, CardOCRInfo paramCardOCRInfo)
  {
    int i3 = 0;
    int i2 = 0;
    int i1;
    if (paramBusinessCard != null)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        i1 = 0;
        while (i1 < paramBusinessCard.mobilesNum.size())
        {
          paramCardOCRInfo = (String)paramBusinessCard.mobilesNum.get(i1);
          a(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramCardOCRInfo, 1, 15);
          i1 += 1;
        }
        this.v = paramBusinessCard.mobilesNum.size();
        if (this.v >= 3) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (paramBusinessCard.uinInfos.isEmpty()) {
          break label303;
        }
        i1 = i2;
        while (i1 < paramBusinessCard.uinInfos.size())
        {
          paramCardOCRInfo = ((CardUinInfo)paramBusinessCard.uinInfos.get(i1)).jdField_a_of_type_JavaLangString;
          if (!TextUtils.isEmpty(paramCardOCRInfo)) {
            a(paramCardOCRInfo, i1);
          }
          i1 += 1;
        }
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.v = 1;
      }
      this.w = paramBusinessCard.uinInfos.size();
      if (this.w >= 2) {
        this.f.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
        if (paramBusinessCard.descs.isEmpty()) {
          break label348;
        }
        paramCardOCRInfo = paramBusinessCard.descs.iterator();
        while (paramCardOCRInfo.hasNext())
        {
          str = (String)paramCardOCRInfo.next();
          a(this.jdField_e_of_type_AndroidWidgetLinearLayout, str, 2, 90);
        }
        label303:
        a(null, 0);
        this.w = 1;
      }
      this.x = paramBusinessCard.descs.size();
      if (this.x >= 2) {
        this.g.setVisibility(8);
      }
    }
    label348:
    while (paramCardOCRInfo == null)
    {
      String str;
      return;
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 90);
      this.x = 1;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      i1 = 0;
      while (i1 < paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size())
      {
        paramBusinessCard = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(i1);
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, paramBusinessCard, 1, 15);
        i1 += 1;
      }
    }
    for (this.v = paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size();; this.v = 1)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (paramCardOCRInfo.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label579;
      }
      i1 = i3;
      while (i1 < paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size())
      {
        a((String)paramCardOCRInfo.jdField_a_of_type_JavaUtilList.get(i1), i1);
        i1 += 1;
      }
      a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
    }
    for (this.w = paramCardOCRInfo.jdField_a_of_type_JavaUtilList.size();; this.w = 1)
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 90);
      this.x = 1;
      return;
      label579:
      a(null, 0);
    }
  }
  
  private void a(BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      paramBusinessCard.cardId = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      paramBusinessCard.bindUin = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin;
      if (this.t == 2) {
        paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName;
      }
    }
    if (this.t != 2) {
      paramBusinessCard.cardName = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
    {
      paramBusinessCard.picUrl = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaLangString;
      paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
    }
    for (;;)
    {
      paramBusinessCard.company = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      paramBusinessCard.mobilesNum.clear();
      i1 = 0;
      while (i1 < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject = ((EditText)this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBusinessCard.mobilesNum.add(localObject);
        }
        i1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        paramBusinessCard.picUrl = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl;
        paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo;
      }
    }
    paramBusinessCard.qqNum.clear();
    int i1 = 0;
    while (i1 < this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131301384);
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText().toString().trim();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBusinessCard.qqNum.add(localObject);
          }
        }
      }
      i1 += 1;
    }
    paramBusinessCard.descs.clear();
    i1 = 0;
    while (i1 < this.jdField_e_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject = ((EditText)this.jdField_e_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.descs.add(localObject);
      }
      i1 += 1;
    }
    if (paramBoolean)
    {
      if (this.t != 0) {
        break label624;
      }
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.cardName)) {
        localObject = "1";
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, (String)localObject, "", "", "");
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.company)) {
        localObject = "1";
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, (String)localObject, "", "", "");
      localObject = paramBusinessCard.qqNum.size() + "";
      ReportController.b(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, (String)localObject, "", "", "");
      paramBusinessCard = paramBusinessCard.descs.size() + "";
      ReportController.b(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, paramBusinessCard, "", "", "");
    }
    label624:
    while (getIntent().getIntExtra("source_activity", 0) != 1) {
      return;
    }
    Object localObject = "0";
    if (!TextUtils.isEmpty(paramBusinessCard.cardName)) {
      localObject = "1";
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
    localObject = "0";
    if (!TextUtils.isEmpty(paramBusinessCard.company)) {
      localObject = "1";
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, (String)localObject, "", "", "");
    localObject = paramBusinessCard.qqNum.size() + "";
    ReportController.b(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, (String)localObject, "", "", "");
    paramBusinessCard = paramBusinessCard.descs.size() + "";
    ReportController.b(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, paramBusinessCard, "", "", "");
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    int i3 = 1;
    if (paramCardOCRInfo == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), paramCardOCRInfo.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    int i1;
    for (int i2 = 1;; i2 = 0)
    {
      localObject = new ArrayList();
      i1 = 0;
      while (i1 < this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        String str = ((EditText)this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).getText().toString().trim();
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)localObject).add(str);
        }
        i1 += 1;
      }
    }
    if ((!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) && (!((ArrayList)localObject).isEmpty()))
    {
      paramCardOCRInfo = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (TextUtils.isEmpty(paramCardOCRInfo)) {
        break label257;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramCardOCRInfo.equals((String)((Iterator)localObject).next())) {
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      if ((i2 != 0) && (i1 != 0)) {
        i1 = i3;
      }
      for (;;)
      {
        BusinessCardUtils.a(this.app.a(), i1);
        return;
        if ((!paramCardOCRInfo.jdField_b_of_type_JavaUtilList.isEmpty()) || (!((ArrayList)localObject).isEmpty())) {
          break label257;
        }
        i1 = 0;
        break;
        if (i2 != 0) {
          i1 = 2;
        } else if (i1 != 0) {
          i1 = 3;
        } else {
          i1 = 0;
        }
      }
      label257:
      i1 = 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, getString(2131371266, new Object[] { paramString1, paramString2 }), 2131367259, 2131367258, new qvd(this), new qve(this, paramString2));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void a(String paramString1, String paramString2, List paramList)
  {
    ContentValues localContentValues = new ContentValues();
    Uri localUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
    if ((localUri == null) || (ContentUris.parseId(localUri) <= 0L))
    {
      runOnUiThread(new qvj(this));
      return;
    }
    long l1 = ContentUris.parseId(localUri);
    if ((paramString1 != null) && (paramList != null) && (paramList.size() > 0))
    {
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l1));
      localContentValues.put("mimetype", "vnd.android.cursor.item/name");
      localContentValues.put("data2", paramString1);
      getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      if (paramString2 != null)
      {
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l1));
        localContentValues.put("mimetype", "vnd.android.cursor.item/organization");
        localContentValues.put("data1", paramString2);
        localContentValues.put("data2", Integer.valueOf(1));
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l1));
        localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        localContentValues.put("data1", paramString2);
        localContentValues.put("data2", Integer.valueOf(2));
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      }
    }
    this.jdField_d_of_type_Boolean = true;
    ReportController.b(this.app, "CliOper", "", "", "0X80064E4", "0X80064E4", 0, 0, "", "", "", "");
  }
  
  private void a(List paramList, LinearLayout paramLinearLayout, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    int i1;
    Object localObject;
    if (paramList.size() > 0)
    {
      localArrayList = new ArrayList();
      i1 = 0;
      if (i1 < paramLinearLayout.getChildCount())
      {
        localObject = paramLinearLayout.getChildAt(i1);
        if ((localObject instanceof RelativeLayout)) {
          localObject = (EditText)((View)localObject).findViewById(2131301384);
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
      i1 += 1;
      break;
      if ((localObject instanceof EditText))
      {
        localObject = (EditText)localObject;
        continue;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localArrayList.add(localObject);
          }
        }
        if (paramInt1 == 1) {}
        for (int i2 = 3;; i2 = 2)
        {
          if (localArrayList.size() > i2) {}
          for (i1 = localArrayList.size() - i2;; i1 = 0)
          {
            if (localArrayList.size() > 0) {
              paramLinearLayout.removeAllViews();
            }
            int i3 = i1;
            int i4 = 0;
            if (i3 < localArrayList.size())
            {
              paramList = (String)localArrayList.get(i3);
              if (paramInt1 != 0) {
                a(paramLinearLayout, paramList, paramInt1, paramInt2);
              }
              for (;;)
              {
                i4 += 1;
                i3 += 1;
                break;
                a(paramList, i3 - i1);
              }
            }
            paramList = this.jdField_e_of_type_AndroidWidgetTextView;
            if (paramInt1 == 0) {
              paramList = this.f;
            }
            while (i4 == i2)
            {
              paramList.setVisibility(8);
              return;
              if (paramInt1 == 2) {
                paramList = this.g;
              }
            }
            if ((paramInt1 == 0) && (a()))
            {
              paramList.setVisibility(8);
              return;
            }
            paramList.setVisibility(0);
            return;
          }
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if (paramBoolean2) {
        c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    a(paramBoolean3);
  }
  
  private boolean a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBusinessCard2 == null)
    {
      bool1 = true;
      return bool1;
    }
    if (!a(paramBusinessCard2.cardName, paramBusinessCard1.cardName)) {
      return true;
    }
    if (!a(paramBusinessCard2.picUrl, paramBusinessCard1.picUrl)) {
      return true;
    }
    if (!a(paramBusinessCard2.company, paramBusinessCard1.company)) {
      return true;
    }
    if (paramBusinessCard1.mobilesNum.size() != paramBusinessCard2.mobilesNum.size()) {
      return true;
    }
    int i1 = 0;
    while (i1 < paramBusinessCard2.mobilesNum.size())
    {
      if (!((String)paramBusinessCard1.mobilesNum.get(i1)).equals(paramBusinessCard2.mobilesNum.get(i1))) {
        return true;
      }
      i1 += 1;
    }
    if (paramBusinessCard1.descs.size() != paramBusinessCard2.descs.size()) {
      return true;
    }
    i1 = 0;
    while (i1 < paramBusinessCard2.descs.size())
    {
      if (!((String)paramBusinessCard1.descs.get(i1)).equals(paramBusinessCard2.descs.get(i1))) {
        return true;
      }
      i1 += 1;
    }
    if (paramBusinessCard1.qqNum.size() != paramBusinessCard2.uinInfos.size()) {
      return true;
    }
    i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= paramBusinessCard2.uinInfos.size()) {
        break;
      }
      if (!((String)paramBusinessCard1.qqNum.get(i1)).equals(((CardUinInfo)paramBusinessCard2.uinInfos.get(i1)).jdField_a_of_type_JavaLangString)) {
        return true;
      }
      i1 += 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
  
  private boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) && ((((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardType == 1))) {
        paramArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.uinInfos.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (CardUinInfo)localIterator.next();
        if (((CardUinInfo)localObject).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        } else if (((CardUinInfo)localObject).jdField_b_of_type_Boolean) {
          paramArrayList2.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        } else {
          paramArrayList4.add(((CardUinInfo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      localIterator = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobileInfos.iterator();
      while (localIterator.hasNext())
      {
        localObject = (CardMobileInfo)localIterator.next();
        if (((CardMobileInfo)localObject).jdField_a_of_type_Boolean) {
          paramArrayList1.add(((CardMobileInfo)localObject).jdField_b_of_type_JavaLangString);
        } else {
          paramArrayList3.add(((CardMobileInfo)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      return (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty()) || (!paramArrayList3.isEmpty()) || (!paramArrayList4.isEmpty());
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131301360);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131301362);
    Object localObject = (TextView)findViewById(2131298586);
    if (this.t == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131367739));
      if (paramBoolean) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString1);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(paramString2);
      if (this.jdField_a_of_type_Boolean)
      {
        localRelativeLayout2.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131371235);
        paramString1 = new qvw(this, 45, this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(paramString1);
        localRelativeLayout1.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131371237);
        paramString1 = new qvw(this, 90, this.jdField_b_of_type_AndroidWidgetEditText);
        this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(paramString1);
        return;
        if (this.m != null)
        {
          paramString1 = this.m;
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)))
        {
          localObject = (FriendsManager)this.app.getManager(50);
          if (localObject == null) {}
          for (paramString1 = null;; paramString1 = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))
          {
            if ((paramString1 == null) || (paramString1.strReMark == null) || (paramString1.strReMark.length() <= 0)) {
              break label298;
            }
            paramString1 = paramString1.strReMark;
            break;
          }
          label298:
          if (localObject == null) {}
          for (paramString1 = null;; paramString1 = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))
          {
            if ((paramString1 == null) || (paramString1.remark == null) || (paramString1.isRemark != 1)) {
              break label440;
            }
            paramString1 = paramString1.remark;
            break;
          }
          ((TextView)localObject).setText(super.getResources().getString(2131371234));
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
        if (TextUtils.isEmpty(paramString2))
        {
          localRelativeLayout1.setVisibility(8);
          return;
        }
        localRelativeLayout1.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
        this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_b_of_type_AndroidWidgetEditText.setHint("");
        return;
      }
      label440:
      paramString1 = "";
    }
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.l = (paramString + "/?01");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      int i1 = getResources().getDisplayMetrics().widthPixels;
      int i2 = i1 * 600 / 1000;
      paramString = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramString.width = i1;
      paramString.height = i2;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString);
      try
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mRequestWidth = 1000;
        paramString.mRequestHeight = 600;
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130840567);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130840567);
        paramString = URLDrawable.getDrawable(this.l, paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    findViewById(2131301358).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131371261));
    if (this.t == 3) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131371262));
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, super.getResources().getString(2131371250), 2131367262, 2131367263, new qvf(this), new qvg(this, paramString));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentIntent = super.getIntent();
    this.t = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("mode_type", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_edit_mode", false);
    this.k = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("cur_card_id");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_card_body"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("cur_ocr_info"));
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("finish_immedia", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_need_report_edit", false);
    this.m = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("has_local_remark");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
    if (this.k != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(this.k);
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        ThreadManager.a(new qvb(this), 8, null, true);
      }
      if (this.t != 3) {
        BusinessCardServlet.a(this.app, this.k, false, 3);
      }
    }
    for (;;)
    {
      if ((this.t == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
        this.u = 0;
      }
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
      h();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return;
      BusinessCardServlet.a(this.app, this.k, true, 3);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
        this.k = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      }
    }
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, paramString, 2131370481, 2131369982, new qvh(this), new qvi(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void f()
  {
    super.setContentView(2130904091);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299491));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    a();
    g();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301357));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301359));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131301361));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131301364));
    this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300564));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301365));
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    for (;;)
    {
      a(true);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
      {
        c(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_b_of_type_JavaLangString);
        b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString, null, true);
      }
      else
      {
        c(null);
        b(null, null, true);
      }
    }
  }
  
  private void f(String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.a(paramString, (String)localObject, false);
      localObject = new QZoneDistributedAppCtrl.Control();
      ((QZoneDistributedAppCtrl.Control)localObject).a = 5;
      QZoneDistributedAppCtrl.a(paramString).a((QZoneDistributedAppCtrl.Control)localObject);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.t == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371227);
        if (this.t != 4) {
          break label164;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        label42:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131367976);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130843457));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if ((this.t == 2) || (this.t == 3)) {
          break label244;
        }
        if (this.t != 4) {
          break label185;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetButton.setText(2131371252);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    label164:
    label185:
    label244:
    label504:
    label516:
    do
    {
      return;
      if (this.t == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371224);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371229);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131368729);
      break label42;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetButton.setText(2131371251);
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131371249);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      if (this.t == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371224);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131368747);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131367975);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(super.getResources().getDrawable(2130843454));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131371255);
        this.jdField_b_of_type_AndroidWidgetButton.setText(2131371254);
        if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString))) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0))) {
          break label540;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.jdField_b_of_type_JavaLangString))) {
          break label504;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        if (this.t == 3) {
          this.jdField_b_of_type_AndroidWidgetButton.setText(2131371253);
        }
      }
      for (;;)
      {
        if ((this.t != 3) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName))) {
          break label516;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371228);
        break;
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    return;
    label540:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new qvk(this, new Handler(this.app.a().getMainLooper()));
      this.app.a().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
      }
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  String a(String paramString)
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str2)))
    {
      String str1 = paramString;
      if (this.t == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName = paramString;
        }
        str1 = paramString;
        if (!TextUtils.isEmpty(str2))
        {
          a(str2, paramString);
          str1 = str2;
        }
      }
      return str1;
    }
    return str2;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301369));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301370));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131301371));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301366));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131301367));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131301368));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 9999);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_max", 1);
    startActivityForResult(localIntent, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setTextColor(super.getResources().getColor(2131428262));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130843292));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this, 44.0F));
    localTextView.setPadding(0, 0, AIOUtils.a(50.0F, getResources()), 0);
    if (paramInt == 1)
    {
      localTextView.setTag(paramString);
      localTextView.setOnClickListener(new qvr(this));
      paramString = localLayoutParams;
    }
    for (;;)
    {
      paramLinearLayout.addView(localTextView, paramString);
      return;
      paramString = localLayoutParams;
      if (paramInt == 2)
      {
        paramString = new LinearLayout.LayoutParams(-1, -2);
        localTextView.setMinHeight(DisplayUtil.a(this, 44.0F));
        localTextView.setPadding(0, AIOUtils.a(12.0F, getResources()), AIOUtils.a(50.0F, getResources()), AIOUtils.a(10.0F, getResources()));
      }
    }
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2)
  {
    EditText localEditText = new EditText(this);
    localEditText.setText(paramString);
    localEditText.setTextSize(16.0F);
    localEditText.setTextColor(super.getResources().getColor(2131428262));
    localEditText.setHintTextColor(super.getResources().getColor(2131427660));
    localEditText.setBackgroundDrawable(super.getResources().getDrawable(2130843292));
    localEditText.setGravity(16);
    localEditText.setPadding(0, 0, AIOUtils.a(50.0F, getResources()), 0);
    paramString = new LinearLayout.LayoutParams(-1, AIOUtils.a(44.0F, getResources()));
    if (paramInt1 != 2)
    {
      localEditText.setInputType(2);
      localEditText.setHint(2131371239);
    }
    for (;;)
    {
      paramLinearLayout.addView(localEditText, paramString);
      localEditText.addTextChangedListener(new qvw(this, paramInt2, localEditText));
      return;
      paramString = new LinearLayout.LayoutParams(-1, -2);
      localEditText.setMinHeight(DisplayUtil.a(this, 44.0F));
      localEditText.setOnEditorActionListener(this);
      localEditText.setPadding(0, AIOUtils.a(12.0F, getResources()), AIOUtils.a(50.0F, getResources()), AIOUtils.a(10.0F, getResources()));
      localEditText.setHint(2131371245);
    }
  }
  
  public void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.c(2131371259);
    localActionSheet.c(2131371260);
    localActionSheet.d(2131367262);
    localActionSheet.a(new qvu(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2130904098, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131301384);
    localEditText.addTextChangedListener(new qvw(this, 15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131301385);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new qvn(this));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 1;
    if (paramBoolean)
    {
      i2 = 0;
      i1 = 2;
    }
    super.startActivity(AddFriendLogicActivity.a(this, i1, paramString1, null, 3026, i2, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null));
    ReportController.b(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301344));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301349));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301354));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301373));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.f = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301375));
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
      this.g = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301377));
      this.g.setVisibility(0);
      this.g.setOnClickListener(this);
      if (a())
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301347).setVisibility(8);
        this.f.setVisibility(8);
      }
      if (paramBoolean) {
        a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301344));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301349));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301354));
      if (a())
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131301347).setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.w("BusinessCard_EditActivity", 2, "名片备注不应该出现详情态");
        }
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (!paramBoolean));
    a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
  }
  
  public boolean a()
  {
    return (this.t == 3) || (this.t == 2);
  }
  
  void b()
  {
    boolean bool = true;
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.c(2131371230);
    localActionSheet.c(2131371233);
    if (getIntent().getIntExtra("source_activity", 0) == 1) {}
    for (;;)
    {
      if (this.t == 2) {
        localActionSheet.c(2131371232);
      }
      localActionSheet.d(2131367262);
      localActionSheet.a(new qvt(this, bool, localActionSheet));
      localActionSheet.show();
      return;
      bool = false;
    }
  }
  
  public void b(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null) {}
    try
    {
      this.app.a().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      }
    } while ((paramIntent == null) || (!this.jdField_a_of_type_Boolean));
    paramIntent = (ResultRecord)paramIntent.get(0);
    paramInt2 = i1;
    while (paramInt2 < this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt2);
      if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
      {
        localObject = (EditText)((View)localObject).findViewById(2131301384);
        if (localObject != null)
        {
          ((EditText)localObject).setText(paramIntent.jdField_a_of_type_JavaLangString);
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          localObject = (CardOCRInfo)paramIntent.getParcelableExtra("extra_return_ocr_info");
          if (localObject == null) {
            break;
          }
          if (this.u == -1) {
            this.u = 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)localObject);
          String str1 = a(((CardOCRInfo)localObject).jdField_a_of_type_JavaLangString);
          String str2 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
          c(((CardOCRInfo)localObject).jdField_b_of_type_JavaLangString);
          b(str1, str2, false);
          a(((CardOCRInfo)localObject).jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_AndroidWidgetLinearLayout, 1, 15);
          a(((CardOCRInfo)localObject).jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_AndroidWidgetLinearLayout, 0, 15);
          this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("extra_need_report_edit", false);
          return;
          localObject = (BusinessCard)paramIntent.getParcelableExtra("Extra_Result_Data");
          if ((localObject == null) || (!this.jdField_a_of_type_Boolean)) {
            break;
          }
          str1 = a(((BusinessCard)localObject).cardName);
          paramIntent = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
          if (!TextUtils.isEmpty(((BusinessCard)localObject).company)) {
            paramIntent = ((BusinessCard)localObject).company;
          }
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((BusinessCard)localObject).OCRInfo;
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId = ((BusinessCard)localObject).cardId;
            this.k = ((BusinessCard)localObject).cardId;
          }
          if (!TextUtils.isEmpty(((BusinessCard)localObject).bindUin)) {
            this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(((BusinessCard)localObject).bindUin);
          }
          c(((BusinessCard)localObject).picUrl);
          b(str1, paramIntent, false);
          a(((BusinessCard)localObject).mobilesNum, this.jdField_c_of_type_AndroidWidgetLinearLayout, 1, 15);
          a(((BusinessCard)localObject).qqNum, this.jdField_d_of_type_AndroidWidgetLinearLayout, 0, 15);
          a(((BusinessCard)localObject).descs, this.jdField_e_of_type_AndroidWidgetLinearLayout, 2, 90);
          a(2131371263, 2);
          return;
          paramIntent.putExtra("selfSet_leftViewText", getString(2131367566));
          localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
          return;
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)((WeakReference)localIterator.next()).get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Intent localIntent = new Intent(this, FlowCameraPhotoActivity.class);
      localIntent.putExtra("is_upload_photo", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramIntent);
      localIntent.putExtra("extra_return_result", true);
      startActivityForResult(localIntent, 10);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected boolean onBackEvent()
  {
    InputMethodUtil.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, false);
      if (a(localBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
      {
        e(super.getResources().getString(2131371673));
        return true;
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing()))
      {
        finish();
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
      {
        super.finish();
        return true;
      }
      a(false, false, false);
      return true;
    }
    super.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131297083: 
    case 2131297183: 
    case 2131301370: 
      do
      {
        do
        {
          return;
          onBackEvent();
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break label402;
          }
          InputMethodUtil.a(this);
          localObject1 = new BusinessCard();
          a((BusinessCard)localObject1, true);
          if (this.jdField_c_of_type_Boolean)
          {
            a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
            this.jdField_c_of_type_Boolean = false;
          }
          if ((this.t != 2) || (this.m == null)) {
            break;
          }
          ((BusinessCardManager)this.app.getManager(111)).a(((BusinessCard)localObject1).bindUin, (BusinessCard)localObject1);
        } while (isFinishing());
        paramView = getIntent();
        this.m = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        paramView.putExtra("has_local_remark", this.m);
        setResult(-1, paramView);
        finish();
        return;
        if ((this.t == 2) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)) {
          f(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
        }
        if (a((BusinessCard)localObject1, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
        {
          if (!NetworkUtil.e(this))
          {
            a(2131368805, 1);
            return;
          }
          paramView = Boolean.valueOf(false);
          if (this.t == 3) {
            paramView = Boolean.valueOf(true);
          }
          if ((((BusinessCard)localObject1).cardId != null) && (((BusinessCard)localObject1).cardId.length() > 0))
          {
            BusinessCardServlet.b(this.app, (BusinessCard)localObject1, paramView.booleanValue());
            b("修改名片...");
            return;
          }
          BusinessCardServlet.a(this.app, (BusinessCard)localObject1, paramView.booleanValue());
          b("创建名片...");
          return;
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (!isFinishing()))
        {
          finish();
          return;
        }
        a(false, false, false);
        return;
        a(true, false, true);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null);
      ThreadManager.a(new qvs(this), 8, null, true);
      return;
    case 2131301371: 
      label402:
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null)) {
        break;
      }
    }
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo; paramView != null; paramView = null)
    {
      if (paramView.jdField_a_of_type_JavaLangString == null) {
        paramView.jdField_a_of_type_JavaLangString = "";
      }
      if ((paramView.jdField_b_of_type_JavaUtilList != null) && (paramView.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        localObject1 = (String)paramView.jdField_b_of_type_JavaUtilList.get(0);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      for (;;)
      {
        Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
        Object localObject3 = "url=" + paramView.jdField_b_of_type_JavaLangString + ";name=" + paramView.jdField_a_of_type_JavaLangString + ";phone=" + (String)localObject1;
        localObject2 = ((AbsShareMsg.Builder)localObject2).c(73).a(getString(2131371269, new Object[] { paramView.jdField_a_of_type_JavaLangString })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(getResources().getString(2131371270)).a();
        localObject3 = new StructMsgItemLayoutDefault();
        ((AbsStructMsgItem)localObject3).d(1);
        ((AbsStructMsgItem)localObject3).b(super.getString(2131371268));
        StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
        localStructMsgItemLayout2.d(3);
        localStructMsgItemLayout2.a(new StructMsgItemCover(paramView.jdField_b_of_type_JavaLangString + "/?02"));
        localStructMsgItemLayout2.a(new StructMsgItemTitle(paramView.jdField_a_of_type_JavaLangString));
        localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
        ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
        ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("req_type", 5);
        ((Bundle)localObject1).putString("image_url", paramView.jdField_b_of_type_JavaLangString);
        localObject1 = (StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1);
        BusinessCardUtils.a(paramView.jdField_b_of_type_JavaLangString);
        paramView = new Bundle();
        paramView.putInt("forward_type", 20);
        paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
        paramView.putByteArray("struct_msg_show_in_dialog", ((StructMsgForImageShare)localObject1).getBytes());
        paramView.putBoolean("k_dataline", false);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramView);
        ForwardBaseOption.a(this, (Intent)localObject1, 21);
        ReportController.b(this.app, "CliOper", "", "", "0X80064E5", "0X80064E5", 0, 0, "", "", "", "");
        return;
        if (this.t == 4)
        {
          InputMethodUtil.a(this);
          paramView = new BusinessCard();
          a(paramView, true);
          if (!NetworkUtil.e(this))
          {
            a(2131368805, 1);
            return;
          }
          BusinessCardServlet.a(this.app, paramView, false);
          b("创建名片...");
          return;
        }
        paramView = new Intent(getActivity(), FlowCameraPhotoActivity.class);
        paramView.putExtra("extra_return_result", true);
        startActivityForResult(paramView, 10);
        return;
        localObject1 = this.k;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
          }
        }
        if (paramView == null) {
          break;
        }
        d(paramView);
        return;
        if (!this.jdField_a_of_type_Boolean) {
          a(true, false, true);
        }
        b();
        return;
        paramView = new Intent(this, CardPicGalleryActivity.class);
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(this.l)) {
          ((ArrayList)localObject1).add(this.l);
        }
        paramView.putStringArrayListExtra("business_card_pics", (ArrayList)localObject1);
        paramView.putExtra("is_edit_mode", this.jdField_a_of_type_Boolean);
        startActivityForResult(paramView, 11);
        overridePendingTransition(2130968800, 0);
        return;
        a(this.jdField_c_of_type_AndroidWidgetLinearLayout, null, 1, 15);
        this.v += 1;
        if (this.v < 3) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        a(null, this.w);
        this.w += 1;
        if (this.w < 2) {
          break;
        }
        this.f.setVisibility(8);
        return;
        a(this.jdField_e_of_type_AndroidWidgetLinearLayout, null, 2, 90);
        this.x += 1;
        if (this.x < 2) {
          break;
        }
        this.g.setVisibility(8);
        return;
        localObject1 = "";
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.getKeyCode() == 66;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\activity\BusinessCardEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */