package com.tencent.biz.qqstory.pgc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.SearchType;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.XListView;
import ika;
import ikb;
import ikc;
import java.util.ArrayList;
import java.util.List;

public class PgcSearchActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  public QQStoryHandler a;
  private QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public SearchResultAdapter a;
  public XListView a;
  public String a;
  int b;
  
  public PgcSearchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 15;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ikc(this);
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("type", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("keyword");
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302347));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298733));
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter = new SearchResultAdapter(this, this.app, this.jdField_a_of_type_Int + 1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    Object localObject = (InputMethodManager)getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ika(this, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297767));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298458));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298334);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ikb(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)findViewById(2131300876);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(this);
  }
  
  public void a(UserInfo paramUserInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramUserInfo.type, paramUserInfo.unionId, paramInt, 3);
  }
  
  public void a(String paramString)
  {
    if (NetworkUtil.h(this))
    {
      if (TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.a();
      }
      ArrayList localArrayList = new ArrayList();
      qqstory_pgc.SearchType localSearchType = new qqstory_pgc.SearchType();
      localSearchType.search_type.set(this.jdField_a_of_type_Int);
      localSearchType.start_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
      localSearchType.search_count.set(this.b);
      localArrayList.add(localSearchType);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString, localArrayList);
      return;
    }
    ToastUtil.a().a("当前网络不可用，请检查你的网络设置");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130904469);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    b();
    a();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300880: 
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\PgcSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */