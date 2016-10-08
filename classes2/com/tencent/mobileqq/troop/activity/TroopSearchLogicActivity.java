package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import vkr;
import vks;

public class TroopSearchLogicActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final long a = 300L;
  public static final String a = "type";
  public static final int b = 2;
  public static final String b = "key_words";
  public static final int c = 1;
  public static final String c = "key_troopUin";
  public Handler a;
  public TroopHandler a;
  public TroopObserver a;
  public QQProgressDialog a;
  public int d;
  public String d;
  
  public TroopSearchLogicActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vkr(this);
    this.jdField_a_of_type_AndroidOsHandler = new vks(this);
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = paramInt1;
    if (this.jdField_d_of_type_JavaLangString.trim().equals(""))
    {
      b(2131368945);
      finish();
      return false;
    }
    if (!NetworkUtil.e(this))
    {
      b(2131369008);
      finish();
      return false;
    }
    a(paramInt2);
    if (this.app == null)
    {
      finish();
      return false;
    }
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    try
    {
      long l = Long.parseLong(this.app.a());
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, 0, 1, this.jdField_d_of_type_JavaLangString, 1, 0L);
      return true;
    }
    catch (Exception paramString)
    {
      finish();
    }
    return false;
  }
  
  /* Error */
  public Boolean a(String paramString)
  {
    // Byte code:
    //   0: new 112	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 115	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: ldc 117
    //   12: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_2
    //   17: ldc 123
    //   19: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 129	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_3
    //   26: aload_1
    //   27: ifnull +20 -> 47
    //   30: ldc 63
    //   32: aload_1
    //   33: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne +11 -> 47
    //   39: aload_1
    //   40: invokevirtual 133	java/lang/String:length	()I
    //   43: iconst_5
    //   44: if_icmpge +12 -> 56
    //   47: aload_0
    //   48: invokevirtual 74	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   51: iconst_0
    //   52: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: areturn
    //   56: aload_0
    //   57: aload_1
    //   58: iload_3
    //   59: ldc -116
    //   61: invokespecial 142	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:a	(Ljava/lang/String;II)Z
    //   64: istore 4
    //   66: iload 4
    //   68: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   71: areturn
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 74	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   77: iconst_0
    //   78: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: areturn
    //   82: astore_1
    //   83: aload_0
    //   84: invokevirtual 74	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   87: iconst_0
    //   88: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   91: areturn
    //   92: astore_2
    //   93: iconst_0
    //   94: istore_3
    //   95: goto -69 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	TroopSearchLogicActivity
    //   0	98	1	paramString	String
    //   8	9	2	localJSONObject	org.json.JSONObject
    //   92	1	2	localException	Exception
    //   25	70	3	i	int
    //   64	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	16	72	org/json/JSONException
    //   16	26	72	org/json/JSONException
    //   30	47	72	org/json/JSONException
    //   47	56	72	org/json/JSONException
    //   56	66	72	org/json/JSONException
    //   0	9	82	org/json/JSONException
    //   73	77	82	org/json/JSONException
    //   16	26	92	java/lang/Exception
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: new 112	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 115	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: ldc -90
    //   12: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_2
    //   17: ldc 123
    //   19: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 129	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_3
    //   26: aload_0
    //   27: aload_1
    //   28: iload_3
    //   29: ldc -89
    //   31: invokespecial 142	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:a	(Ljava/lang/String;II)Z
    //   34: istore 4
    //   36: iload 4
    //   38: ireturn
    //   39: astore_2
    //   40: iconst_0
    //   41: istore_3
    //   42: goto -16 -> 26
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 74	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   50: iconst_0
    //   51: ireturn
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 74	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   57: iconst_0
    //   58: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	TroopSearchLogicActivity
    //   0	59	1	paramString	String
    //   8	9	2	localJSONObject	org.json.JSONObject
    //   39	1	2	localException	Exception
    //   25	17	3	i	int
    //   34	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   16	26	39	java/lang/Exception
    //   9	16	45	org/json/JSONException
    //   16	26	45	org/json/JSONException
    //   26	36	45	org/json/JSONException
    //   0	9	52	org/json/JSONException
    //   46	50	52	org/json/JSONException
  }
  
  public final void b(int paramInt)
  {
    QQToast.a(this, paramInt, 0).b(getTitleBarHeight());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
    if (i == 2)
    {
      a(paramBundle.getStringExtra("key_words"));
      return true;
    }
    if (i == 1)
    {
      a(paramBundle.getStringExtra("key_words"));
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopSearchLogicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */