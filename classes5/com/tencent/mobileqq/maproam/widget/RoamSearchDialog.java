package com.tencent.mobileqq.maproam.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import tcr;
import tcs;
import tct;
import tcu;
import tcx;
import tcz;

public class RoamSearchDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 10;
  public static final String a;
  public static final int b = 20000;
  public static final int c = 10000;
  public static final int d = 8192;
  public static final int e = 10;
  public static final int f = 20000;
  public static final int g = 10000;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 5;
  public long a;
  public Context a;
  public Button a;
  public EditText a;
  public ImageButton a;
  public TextView a;
  public RoamSearchDialog.OnRoamResultObserver a;
  public RoamSearchDialog.OnSearchResultItemClick a;
  public XListView a;
  public List a;
  public tcz a;
  public String b;
  public int k = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RoamSearchDialog.class.getSimpleName();
  }
  
  public RoamSearchDialog(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "北京";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903402);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    b();
    c();
    d();
    e();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297766));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Tcz = new tcz(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Tcz);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new tcr(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new tcs(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297767));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368078);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131371218);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new tct(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    tcx localtcx = new tcx(this, null);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localtcx);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localtcx);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300876));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_Long = l;
      this.k = 1;
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_JavaLangString, 5, this.k);
    }
  }
  
  public void a(RoamSearchDialog.OnRoamResultObserver paramOnRoamResultObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = paramOnRoamResultObserver;
  }
  
  public void a(RoamSearchDialog.OnSearchResultItemClick paramOnSearchResultItemClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = paramOnSearchResultItemClick;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.a();
    if ((this.jdField_a_of_type_Tcz == null) || (localObject == null) || (localObject != this.jdField_a_of_type_Tcz) || (this.jdField_a_of_type_Tcz.getItemViewType(paramInt) == 1)) {}
    do
    {
      do
      {
        return;
        localObject = (LocationDetail)this.jdField_a_of_type_Tcz.getItem(paramInt);
      } while ((this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick == null) || (localObject == null));
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick.a(paramAdapterView, paramView, paramInt, (LocationDetail)localObject);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "current click location, lat = " + ((LocationDetail)localObject).jdField_a_of_type_Double + ", lon = " + ((LocationDetail)localObject).jdField_b_of_type_Double);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "search poi, currentKeyword = " + paramString1 + ", region = " + paramString2);
    }
    if (paramInt2 == 1)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_Tcz != null) {
        this.jdField_a_of_type_Tcz.notifyDataSetChanged();
      }
    }
    ThreadManager.a(new tcu(this, paramString1, paramString2, paramInt1, paramInt2), 5, null, false);
  }
  
  /* Error */
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +7 -> 14
    //   10: ldc 68
    //   12: astore 5
    //   14: new 301	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 357
    //   24: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokestatic 363	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 365
    //   37: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 5
    //   42: invokestatic 363	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 367
    //   51: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 369
    //   57: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_3
    //   61: invokevirtual 372	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 374
    //   67: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 4
    //   72: invokevirtual 372	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: new 376	org/apache/http/params/BasicHttpParams
    //   82: dup
    //   83: invokespecial 377	org/apache/http/params/BasicHttpParams:<init>	()V
    //   86: astore_2
    //   87: aload_2
    //   88: ldc2_w 378
    //   91: invokestatic 385	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   94: aload_2
    //   95: new 387	org/apache/http/conn/params/ConnPerRouteBean
    //   98: dup
    //   99: bipush 10
    //   101: invokespecial 388	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   104: invokestatic 392	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   107: aload_2
    //   108: bipush 10
    //   110: invokestatic 396	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   113: aload_2
    //   114: sipush 10000
    //   117: invokestatic 401	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   120: aload_2
    //   121: sipush 20000
    //   124: invokestatic 404	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   127: aload_2
    //   128: iconst_1
    //   129: invokestatic 408	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   132: aload_2
    //   133: sipush 8192
    //   136: invokestatic 411	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   139: aload_2
    //   140: getstatic 417	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   143: invokestatic 423	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   146: aload_2
    //   147: ldc_w 425
    //   150: invokestatic 429	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   153: new 431	org/apache/http/impl/client/DefaultHttpClient
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 434	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 74	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   166: aload_2
    //   167: invokestatic 439	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   170: new 441	java/io/BufferedReader
    //   173: dup
    //   174: new 443	java/io/InputStreamReader
    //   177: dup
    //   178: aload_2
    //   179: new 445	org/apache/http/client/methods/HttpGet
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 447	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   187: invokeinterface 453 2 0
    //   192: invokeinterface 459 1 0
    //   197: invokeinterface 465 1 0
    //   202: invokespecial 468	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   205: invokespecial 471	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   208: astore 5
    //   210: ldc_w 473
    //   213: astore_1
    //   214: aload 5
    //   216: invokevirtual 476	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   219: astore 6
    //   221: aload_1
    //   222: astore_2
    //   223: aload 6
    //   225: ifnull +39 -> 264
    //   228: new 301	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   235: aload_1
    //   236: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 6
    //   241: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore_2
    //   248: aload_2
    //   249: astore_1
    //   250: goto -36 -> 214
    //   253: astore_2
    //   254: ldc_w 473
    //   257: astore_1
    //   258: aload_2
    //   259: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   262: aload_1
    //   263: astore_2
    //   264: new 481	org/json/JSONObject
    //   267: dup
    //   268: aload_2
    //   269: invokespecial 482	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload_2
    //   274: ldc_w 484
    //   277: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   280: istore_3
    //   281: aload_2
    //   282: ldc_w 490
    //   285: invokevirtual 493	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 5
    //   290: new 495	android/os/Handler
    //   293: dup
    //   294: invokestatic 501	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   297: invokespecial 504	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   300: astore_1
    //   301: iload_3
    //   302: ifeq +64 -> 366
    //   305: invokestatic 299	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +41 -> 349
    //   311: getstatic 55	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   314: iconst_2
    //   315: new 301	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 302	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 506
    //   325: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload_3
    //   329: invokevirtual 372	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 508
    //   335: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 5
    //   340: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 322	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_1
    //   350: new 510	tcv
    //   353: dup
    //   354: aload_0
    //   355: iload_3
    //   356: aload 5
    //   358: invokespecial 513	tcv:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;ILjava/lang/String;)V
    //   361: invokevirtual 517	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   364: pop
    //   365: return
    //   366: aload_2
    //   367: ldc_w 519
    //   370: invokevirtual 488	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   373: istore 4
    //   375: aload_2
    //   376: ldc_w 521
    //   379: invokevirtual 525	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   382: astore_2
    //   383: new 62	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 64	java/util/ArrayList:<init>	()V
    //   390: astore 5
    //   392: iconst_0
    //   393: istore_3
    //   394: aload_2
    //   395: invokevirtual 531	org/json/JSONArray:length	()I
    //   398: istore 8
    //   400: iload_3
    //   401: iload 8
    //   403: if_icmpge +201 -> 604
    //   406: aload_2
    //   407: iload_3
    //   408: invokevirtual 535	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   411: astore 7
    //   413: new 289	com/tencent/mobileqq/maproam/data/LocationDetail
    //   416: dup
    //   417: invokespecial 536	com/tencent/mobileqq/maproam/data/LocationDetail:<init>	()V
    //   420: astore 6
    //   422: aload 7
    //   424: ldc_w 538
    //   427: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   430: ifeq +16 -> 446
    //   433: aload 6
    //   435: aload 7
    //   437: ldc_w 538
    //   440: invokevirtual 493	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: putfield 543	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   446: aload 7
    //   448: ldc_w 545
    //   451: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   454: ifeq +16 -> 470
    //   457: aload 6
    //   459: aload 7
    //   461: ldc_w 545
    //   464: invokevirtual 493	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: putfield 546	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   470: aload 7
    //   472: ldc_w 548
    //   475: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   478: ifeq +16 -> 494
    //   481: aload 6
    //   483: aload 7
    //   485: ldc_w 548
    //   488: invokevirtual 493	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: putfield 550	com/tencent/mobileqq/maproam/data/LocationDetail:c	Ljava/lang/String;
    //   494: aload 7
    //   496: ldc_w 552
    //   499: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   502: ifeq +16 -> 518
    //   505: aload 6
    //   507: aload 7
    //   509: ldc_w 552
    //   512: invokevirtual 493	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: putfield 554	com/tencent/mobileqq/maproam/data/LocationDetail:d	Ljava/lang/String;
    //   518: aload 7
    //   520: ldc_w 556
    //   523: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   526: ifeq +61 -> 587
    //   529: aload 7
    //   531: ldc_w 556
    //   534: invokevirtual 560	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   537: astore 7
    //   539: aload 7
    //   541: ldc_w 562
    //   544: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   547: ifeq +16 -> 563
    //   550: aload 6
    //   552: aload 7
    //   554: ldc_w 562
    //   557: invokevirtual 566	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   560: putfield 311	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_Double	D
    //   563: aload 7
    //   565: ldc_w 568
    //   568: invokevirtual 542	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   571: ifeq +16 -> 587
    //   574: aload 6
    //   576: aload 7
    //   578: ldc_w 568
    //   581: invokevirtual 566	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   584: putfield 318	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_Double	D
    //   587: aload 5
    //   589: aload 6
    //   591: invokeinterface 572 2 0
    //   596: pop
    //   597: iload_3
    //   598: iconst_1
    //   599: iadd
    //   600: istore_3
    //   601: goto -201 -> 400
    //   604: aload_1
    //   605: new 574	tcw
    //   608: dup
    //   609: aload_0
    //   610: aload 5
    //   612: iload 4
    //   614: invokespecial 577	tcw:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;Ljava/util/List;I)V
    //   617: invokevirtual 517	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   620: pop
    //   621: return
    //   622: astore_1
    //   623: return
    //   624: astore_2
    //   625: goto -367 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	RoamSearchDialog
    //   0	628	1	paramString1	String
    //   0	628	2	paramString2	String
    //   0	628	3	paramInt1	int
    //   0	628	4	paramInt2	int
    //   1	610	5	localObject1	Object
    //   219	371	6	localObject2	Object
    //   411	166	7	localJSONObject	org.json.JSONObject
    //   398	6	8	m	int
    // Exception table:
    //   from	to	target	type
    //   170	210	253	java/io/IOException
    //   264	301	622	org/json/JSONException
    //   305	349	622	org/json/JSONException
    //   349	365	622	org/json/JSONException
    //   366	392	622	org/json/JSONException
    //   394	400	622	org/json/JSONException
    //   406	446	622	org/json/JSONException
    //   446	470	622	org/json/JSONException
    //   470	494	622	org/json/JSONException
    //   494	518	622	org/json/JSONException
    //   518	563	622	org/json/JSONException
    //   563	587	622	org/json/JSONException
    //   587	597	622	org/json/JSONException
    //   604	621	622	org/json/JSONException
    //   214	221	624	java/io/IOException
    //   228	248	624	java/io/IOException
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Tcz != null) {
      this.jdField_a_of_type_Tcz.notifyDataSetChanged();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300880: 
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\widget\RoamSearchDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */