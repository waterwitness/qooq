package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.emosm.EmosmPb.BqAssocInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import rks;

public class EmotionPreviewLayout
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener
{
  static final int jdField_a_of_type_Int = 10000;
  public static String a;
  static final int jdField_b_of_type_Int = 10001;
  static final int jdField_c_of_type_Int = 10002;
  static final int d = 3000;
  public static int f = 10000;
  public static final int i = 66;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  public EditText a;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new rks(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public WeakReferenceHandler a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List a;
  public String b;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  String jdField_c_of_type_JavaLangString;
  int e;
  int g = 0;
  final int h = 2;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPreviewLayout.class.getSimpleName();
  }
  
  public EmotionPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    this.c = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int k = (int)(10.0F * this.jdField_a_of_type_Float);
    super.setPadding(0, k, k, k);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    getBackground().setAlpha(204);
  }
  
  private String a()
  {
    switch (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
    default: 
      return "5";
    case 1: 
      return "0";
    case 4: 
      return "1";
    case 3: 
      return "2";
    }
    return "3";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int n;
    int k;
    label52:
    EmoticonKeyword localEmoticonKeyword;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt1)) {
      if (this.jdField_a_of_type_JavaUtilList.size() >= paramInt2)
      {
        int m = 0;
        n = (int)(66.0F * this.jdField_a_of_type_Float);
        k = paramInt1;
        paramInt1 = m;
        if (k >= paramInt2) {
          break label734;
        }
        localEmoticonKeyword = (EmoticonKeyword)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localEmoticonKeyword._index < f) {
          break label236;
        }
        if (paramInt1 != 0) {
          break label735;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_cache", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
        paramInt1 = 1;
      }
    }
    label122:
    label167:
    label236:
    label734:
    label735:
    for (;;)
    {
      if (TextUtils.isEmpty(this.c)) {
        this.c = (localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
      }
      try
      {
        URL localURL = new URL("emotion_pic", "fromAIO", localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
        if (localURL == null) {
          for (;;)
          {
            k += 1;
            break label52;
            paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
            break;
            if (paramInt1 != 0) {
              break label735;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_local", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
            paramInt1 = 1;
            break label122;
            if (!this.c.equals(localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId)) {
              break label167;
            }
            QLog.i(jdField_a_of_type_JavaLangString, 1, "emoticon keyword same:" + this.c);
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getDrawable ,", localMalformedURLException);
          }
          localObject = null;
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841690));
        }
        if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
          this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841691));
        }
        View localView = LinearLayout.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903076, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131296971);
        if (!localEmoticonKeyword.isSound) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = URLDrawable.getDrawable((URL)localObject, n, n, (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Drawable)this.jdField_b_of_type_JavaLangRefWeakReference.get(), bool);
          if (((URLDrawable)localObject).getStatus() != 1)
          {
            ((URLDrawable)localObject).setTag(localEmoticonKeyword);
            ((URLDrawable)localObject).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            ((URLDrawable)localObject).addHeader("emo_big", "true");
            if ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3)) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          localImageView.setTag(localEmoticonKeyword);
          localImageView.setAdjustViewBounds(false);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setContentDescription("原创表情" + localEmoticonKeyword.name);
          localImageView.setImageDrawable((Drawable)localObject);
          localImageView.setOnClickListener(this);
          localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).width = ((int)(66.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(66.0F * this.jdField_a_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
          if (localEmoticonKeyword.isSound) {
            ((ImageView)localView.findViewById(2131296972)).setVisibility(0);
          }
          super.addView(localView);
          this.e += 1;
          break;
        }
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.j > this.e)
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return;
      }
      Object localObject1 = LinearLayout.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903076, null);
      Object localObject2 = (ImageView)((View)localObject1).findViewById(2131296971);
      ((ImageView)localObject2).setAdjustViewBounds(false);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject2).setContentDescription("原创表情loading");
      ((ImageView)localObject2).setOnClickListener(this);
      ((ImageView)localObject2).setImageResource(2130841690);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject2 = a(0);
      if (localObject2 != null)
      {
        int k = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
        localLayoutParams.bottomMargin = k;
        localLayoutParams.leftMargin = k;
        localLayoutParams.addRule(13);
        ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
        ((ProgressBar)localObject2).setVisibility(0);
      }
      super.addView((View)localObject1);
      localObject1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((EmoticonKeyword)((Iterator)localObject2).next()).eId);
        }
      }
      ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString(), (ArrayList)localObject1);
      return;
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3000L);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000));
  }
  
  ProgressBar a(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    Object localObject1;
    ProgressBar localProgressBar;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > k)
    {
      localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localProgressBar = (ProgressBar)((WeakReference)localObject1).get();
        localObject1 = localProgressBar;
        if (localProgressBar != null)
        {
          localObject1 = localProgressBar;
          if (localProgressBar.getParent() != null)
          {
            localObject1 = (ViewGroup)localProgressBar.getParent();
            if (localObject1 == null) {
              break label156;
            }
            ((ViewGroup)localObject1).removeView(localProgressBar);
            localObject1 = localProgressBar;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        for (;;)
        {
          label156:
          try
          {
            localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}
          try
          {
            localProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838321));
            localObject1 = localProgressBar;
            if (localObject1 != null)
            {
              if (this.jdField_a_of_type_JavaUtilArrayList.size() <= k) {
                break label175;
              }
              this.jdField_a_of_type_JavaUtilArrayList.set(k, new WeakReference(localObject1));
            }
            return (ProgressBar)localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            for (;;)
            {
              localObject2 = localOutOfMemoryError2;
            }
          }
          localObject1 = null;
          break;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "new progressbar oom");
        }
        label175:
        this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(localObject1));
        return (ProgressBar)localObject1;
      }
      ((ProgressBar)localObject1).setVisibility(0);
      return (ProgressBar)localObject1;
      Object localObject2 = null;
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {}
    do
    {
      return;
      int n = super.getChildCount();
      int m = 0;
      int k = 0;
      if (m < n)
      {
        if (!(getChildAt(m) instanceof ViewGroup)) {}
        for (;;)
        {
          m += 1;
          break;
          ViewGroup localViewGroup = (ViewGroup)getChildAt(m);
          if ((localViewGroup.getTag() instanceof EmoticonKeywordForCloud))
          {
            EmoticonKeywordForCloud localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)localViewGroup.getTag();
            if (localEmoticonKeywordForCloud.loadedType == 2)
            {
              if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar))
              {
                localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
                localViewGroup.removeViewAt(localViewGroup.getChildCount() - 1);
              }
              if (m > k)
              {
                super.removeView(localViewGroup);
                super.addView(localViewGroup, k);
              }
              k += 1;
            }
            for (;;)
            {
              break;
              if (localEmoticonKeywordForCloud.loadedType == 3)
              {
                if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar))
                {
                  localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
                  localViewGroup.removeViewAt(localViewGroup.getChildCount() - 1);
                }
                super.removeView(localViewGroup);
                super.addView(localViewGroup);
              }
            }
          }
          k += 1;
        }
      }
      this.g -= 1;
    } while (this.g != 0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3000L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 1;
    int k;
    if (paramBoolean)
    {
      Iterator localIterator1 = paramEmoticonResp.data.iterator();
      paramInt = 1;
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          EmosmPb.BqAssocInfo localBqAssocInfo = (EmosmPb.BqAssocInfo)localIterator1.next();
          EmoticonKeywordForCloud localEmoticonKeywordForCloud = new EmoticonKeywordForCloud();
          localEmoticonKeywordForCloud.loadedType = 0;
          localEmoticonKeywordForCloud.epId = String.valueOf(localBqAssocInfo.u32_tab_id.get());
          localEmoticonKeywordForCloud.eId = localBqAssocInfo.str_item_id.get();
          localEmoticonKeywordForCloud.name = localBqAssocInfo.str_item_name.get();
          localEmoticonKeywordForCloud.encryptKey = localBqAssocInfo.str_item_key.get();
          if ((!TextUtils.isEmpty(localEmoticonKeywordForCloud.epId)) && (!TextUtils.isEmpty(localEmoticonKeywordForCloud.eId)) && (!TextUtils.isEmpty(localEmoticonKeywordForCloud.encryptKey)))
          {
            paramEmoticonResp = localBqAssocInfo.rpt_str_item_keyword.get();
            if ((paramEmoticonResp != null) && (paramEmoticonResp.size() > 0)) {
              if (!paramEmoticonResp.contains(this.jdField_b_of_type_JavaLangString))
              {
                Iterator localIterator2 = paramEmoticonResp.iterator();
                String str;
                do
                {
                  if (!localIterator2.hasNext()) {
                    break;
                  }
                  str = (String)localIterator2.next();
                } while (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str));
                k = 1;
                label271:
                if (k == 0) {}
              }
              else
              {
                localEmoticonKeywordForCloud.inputKeyword = this.jdField_b_of_type_JavaLangString;
                if (paramEmoticonResp.size() > 0)
                {
                  paramEmoticonResp = paramEmoticonResp.toString();
                  label299:
                  localEmoticonKeywordForCloud.keyword = paramEmoticonResp;
                  localEmoticonKeywordForCloud.keywords = paramEmoticonResp;
                  k = localBqAssocInfo.i32_tab_ringtype.get();
                  if (k != 1) {
                    break label526;
                  }
                  localEmoticonKeywordForCloud.isSound = true;
                  label333:
                  localEmoticonKeywordForCloud.jobType = 0;
                  localEmoticonKeywordForCloud.width = 200;
                  localEmoticonKeywordForCloud.height = 200;
                  localEmoticonKeywordForCloud._index = (localBqAssocInfo.u32_tab_id.get() + f);
                  localEmoticonKeywordForCloud.type = localBqAssocInfo.i32_tab_type.get();
                  localEmoticonKeywordForCloud.businessExtra = "";
                  if (localBqAssocInfo.rpt_support_size.has()) {
                    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticonKeywordForCloud.epId, localEmoticonKeywordForCloud, localBqAssocInfo.rpt_support_size.get());
                  }
                  paramInt += 1;
                  localEmoticonKeywordForCloud.valid = true;
                  localArrayList.add(localEmoticonKeywordForCloud);
                  if (localArrayList.size() + this.e < this.j) {
                    break label535;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10000);
      if (1 == paramInt)
      {
        if (this.e > 0)
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3000L);
          return;
          paramEmoticonResp = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
          break label299;
          label526:
          if (k != 4) {
            break label333;
          }
          break;
          label535:
          break;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000));
        return;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10001, localArrayList));
      return;
      k = 0;
      break label271;
      break;
    }
  }
  
  void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (!paramBoolean) {
      break label4;
    }
    label4:
    while ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString())) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    if ((super.getChildCount() > 0) && (!(getChildAt(super.getChildCount() - 1).getTag() instanceof EmoticonKeyword))) {
      super.removeView(getChildAt(super.getChildCount() - 1));
    }
    int m = this.e;
    int k;
    if (paramArrayList.size() + this.e <= this.j)
    {
      k = paramArrayList.size();
      if (k <= paramArrayList.size()) {
        break label810;
      }
    }
    label143:
    label207:
    label571:
    label741:
    label807:
    label810:
    for (int n = paramArrayList.size();; n = k)
    {
      int i1 = 0;
      k = m;
      EmoticonKeywordForCloud localEmoticonKeywordForCloud;
      View localView;
      if (i1 < n)
      {
        localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)paramArrayList.get(i1);
        m = k;
        if (localEmoticonKeywordForCloud != null)
        {
          if (super.getChildCount() < 2) {
            break label207;
          }
          m = k;
        }
        for (;;)
        {
          i1 += 1;
          k = m;
          break label143;
          k = this.j - this.e;
          break;
          if (TextUtils.isEmpty(this.c)) {
            this.c = (localEmoticonKeywordForCloud.epId + "_" + localEmoticonKeywordForCloud.eId);
          }
          while (!this.c.equals(localEmoticonKeywordForCloud.epId + "_" + localEmoticonKeywordForCloud.eId))
          {
            Object localObject2 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            ((PicEmoticonInfo)localObject2).c = 6;
            ((PicEmoticonInfo)localObject2).a = localEmoticonKeywordForCloud;
            ((PicEmoticonInfo)localObject2).j = 3;
            localView = LinearLayout.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903076, null);
            localView.setTag(localEmoticonKeywordForCloud);
            Object localObject1 = (ImageView)localView.findViewById(2131296971);
            ((ImageView)localObject1).setTag(localEmoticonKeywordForCloud);
            ((ImageView)localObject1).setAdjustViewBounds(false);
            ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ImageView)localObject1).setContentDescription("原创表情" + localEmoticonKeywordForCloud.name);
            ((ImageView)localObject1).setOnClickListener(this);
            ((PicEmoticonInfo)localObject2).h = ((int)(66.0F * this.jdField_a_of_type_Float));
            ((PicEmoticonInfo)localObject2).i = ((int)(66.0F * this.jdField_a_of_type_Float));
            localObject2 = ((PicEmoticonInfo)localObject2).a("fromAIO", true);
            m = k;
            if (localObject2 != null)
            {
              ((URLDrawable)localObject2).setTag(localEmoticonKeywordForCloud);
              if (((URLDrawable)localObject2).getStatus() == 1) {
                break label741;
              }
              ((URLDrawable)localObject2).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
              super.addView(localView);
              localEmoticonKeywordForCloud.loadedType = 1;
              ProgressBar localProgressBar = a(this.e);
              if (localProgressBar != null)
              {
                m = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                localProgressBar.setPadding(m, 0, 0, 0);
                int i2 = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m + i2, i2);
                localLayoutParams.bottomMargin = i2;
                localLayoutParams.leftMargin = i2;
                localLayoutParams.addRule(13);
                ((ViewGroup)localView).addView(localProgressBar, localLayoutParams);
                localProgressBar.setVisibility(0);
              }
              this.g += 1;
              ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              m = k;
            }
            localObject1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = ((int)(66.0F * this.jdField_a_of_type_Float));
            ((RelativeLayout.LayoutParams)localObject1).height = ((int)(66.0F * this.jdField_a_of_type_Float));
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
            if (localEmoticonKeywordForCloud.isSound) {
              ((ImageView)localView.findViewById(2131296972)).setVisibility(0);
            }
            this.e += 1;
            break;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 1, "emoticon keyword same:" + this.c);
          m = k;
        }
        if (super.getChildCount() >= k) {
          break label807;
        }
        k = super.getChildCount();
      }
      for (;;)
      {
        super.addView(localView, k);
        k += 1;
        localEmoticonKeywordForCloud.loadedType = 2;
        break label571;
        if (this.g != 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3000L);
        return;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 10000: 
    case 10001: 
      do
      {
        return true;
        setVisibility(8);
        return true;
      } while (paramMessage.obj == null);
      a(true, (ArrayList)paramMessage.obj);
      return true;
    }
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().equals(""))) {
      return;
    }
    Object localObject = paramView.getTag();
    EmoticonKeyword localEmoticonKeyword = null;
    if ((localObject instanceof Emoticon)) {
      localEmoticonKeyword = (EmoticonKeyword)paramView.getTag();
    }
    if (localEmoticonKeyword != null)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("emotion onClick, keyword:").append(this.jdField_b_of_type_JavaLangString).append(", epid_eid:");
        if (localEmoticonKeyword.epId == null) {
          break label231;
        }
        paramView = localEmoticonKeyword.epId;
        localStringBuilder = localStringBuilder.append(paramView).append("_");
        if (localEmoticonKeyword.eId == null) {
          break label238;
        }
        paramView = localEmoticonKeyword.eId;
        label161:
        localStringBuilder = localStringBuilder.append(paramView);
        if (!(localEmoticonKeyword instanceof EmoticonKeywordForCloud)) {
          break label245;
        }
      }
      label231:
      label238:
      label245:
      for (paramView = "-cloud-" + ((EmoticonKeywordForCloud)localEmoticonKeyword).type;; paramView = "-local")
      {
        QLog.d((String)localObject, 2, paramView);
        if (localEmoticonKeyword.epId != null) {
          break label252;
        }
        setVisibility(8);
        return;
        paramView = "~";
        break;
        paramView = "~";
        break label161;
      }
      label252:
      if (!(localEmoticonKeyword instanceof EmoticonKeywordForCloud)) {
        break label514;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_more", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticonKeyword.epId) == null)
      {
        ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(localEmoticonKeyword.epId, EmojiManager.e);
        paramView = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(localEmoticonKeyword.epId);
        if (paramView != null)
        {
          paramView.type = ((EmoticonKeywordForCloud)localEmoticonKeyword).type;
          localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
          if (localObject != null) {
            ((EmoticonManager)localObject).a(paramView);
          }
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10000);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 9501)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        paramView = (EmoticonManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(13);
        localObject = paramView.a(localEmoticonKeyword.epId);
        if ((localObject == null) || (((EmoticonPackage)localObject).jobType != 0) || (((EmoticonPackage)localObject).subType != 4)) {
          break label598;
        }
        paramView.a(((EmoticonPackage)localObject).epId, localEmoticonKeyword, null);
        PicEmoticonInfo.a((EmoticonPackage)localObject, localEmoticonKeyword, (Activity)this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      setVisibility(8);
      return;
      label514:
      if (localEmoticonKeyword._index >= f)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_cache", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_local", 0, 1, localEmoticonKeyword.epId, a(), this.jdField_b_of_type_JavaLangString, "");
      break;
      label598:
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localEmoticonKeyword);
    }
  }
  
  public void setEmoticonKeywordList(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.j = Math.min(2, paramInt);
    this.c = "";
  }
  
  public void setVisibility(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        this.jdField_b_of_type_JavaLangString = str;
        this.e = 0;
        this.g = 0;
        a(0, 2);
        if (this.j <= this.e) {
          break label155;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3002L);
        b();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_more", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
        label111:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 1, "", a(), this.jdField_b_of_type_JavaLangString, "");
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      str = "";
      break;
      label155:
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 10000), 3000L);
      break label111;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10000);
      super.removeAllViews();
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaLangString = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPreviewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */