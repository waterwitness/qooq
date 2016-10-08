package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.UploadItem;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.GridView;
import cooperation.zebra.ZebraPluginProxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import vsh;
import vsj;
import vsk;
import vsm;
import vsn;
import vso;

public class AvatarWallAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static Uri a;
  public static String a;
  public static final String b = "AVATAR_URL_STR";
  protected static final int c = 6;
  public static final String c = "AVATAR_LOCAL_STR";
  public static final int d = 8;
  public static final String d = "PLUS";
  public static final int e = 0;
  public static final String e = "SYSTEM_PHOTO";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final String i = "has_shown_same_city_picture_uploaded_dialog";
  public static final int k = 4;
  public static final int l = 1;
  protected static final int m = 2;
  public static int o = 0;
  public static final int r = 16;
  public static int s = 7;
  protected static final int t = 13;
  protected static final int u = 14;
  protected int a;
  public Bitmap a;
  public Handler a;
  public SparseArray a;
  public QQAppInterface a;
  public TroopAvatarManger a;
  protected AvatarWallAdapter.AddButtonStatusListener a;
  public FaceDecoder a;
  public GridView a;
  protected List a;
  Observer a;
  public WeakReference a;
  protected boolean a;
  public int[] a;
  protected String[] a;
  public int b;
  protected Handler b;
  protected boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  protected String f;
  protected boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  protected boolean k = true;
  protected int n = 2;
  public int p;
  protected final int q = 10;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "AvatarWallAdapter";
  }
  
  public AvatarWallAdapter(WeakReference paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, Handler paramHandler, boolean paramBoolean2, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilObserver = new vsh(this);
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.g = paramString1;
    this.jdField_h_of_type_JavaLangString = paramString2;
    this.e = paramBoolean1;
    a(paramBoolean2);
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    paramWeakReference = (Activity)paramWeakReference.get();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramWeakReference, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    paramQQAppInterface = paramWeakReference.getResources();
    paramString1 = new DisplayMetrics();
    paramWeakReference.getWindowManager().getDefaultDisplay().getMetrics(paramString1);
    int i1 = paramQQAppInterface.getDimensionPixelSize(2131493203);
    this.jdField_i_of_type_Int = ((paramString1.widthPixels - paramQQAppInterface.getDimensionPixelSize(2131493204) * 2 - i1 * 3) / 4);
    paramGridView.setColumnWidth(this.jdField_i_of_type_Int);
    paramGridView.setVerticalSpacing(i1);
    paramGridView.setHorizontalSpacing(i1);
    paramWeakReference = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.g, TroopUploadingTask.class, paramWeakReference);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
    paramGridView.setAdapter(this);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
    localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      localBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramActivity.overridePendingTransition(2130968585, 2130968583);
      ZebraPluginProxy.startPhotoList(paramActivity, localBundle);
      return;
    }
  }
  
  protected static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isFile()) {
        paramFile.delete();
      }
      while (!paramFile.delete())
      {
        return false;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int i1 = 0;
            while (i1 < arrayOfFile.length)
            {
              a(arrayOfFile[i1]);
              i1 += 1;
            }
          }
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      return ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131493206);
    }
    return 0;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    Object localObject = new File(paramString1);
    BitmapFactory.Options localOptions = ImageUtil.a(((File)localObject).getPath(), 100);
    try
    {
      localObject = BitmapFactory.decodeFile(((File)localObject).getPath(), localOptions);
      paramString2 = new File(paramString2);
      if (paramString2.exists()) {
        return 0;
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      return -1;
    }
    try
    {
      int i1 = TroopUtils.a(paramString1);
      paramString1 = (String)localObject;
      if (i1 != 0) {
        paramString1 = ImageUtil.b((Bitmap)localObject, i1);
      }
      ImageUtil.a(paramString1, paramString2);
      return 0;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public AvatarWallAdapter.AvatarInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localActivity == null) {
      return null;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "upload_head_cancel", 0, 0, this.g, String.valueOf(paramInt), "", "");
    if (paramInt == 1) {
      return localActivity.getString(2131364658);
    }
    if (paramInt == 2) {
      return localActivity.getString(2131364659);
    }
    if (paramInt == 3) {
      return localActivity.getString(2131364660);
    }
    if (paramInt == 5) {
      return localActivity.getString(2131364661);
    }
    if (paramInt == 100) {
      return localActivity.getString(2131364673);
    }
    if (paramInt == 101) {
      return localActivity.getString(2131364674);
    }
    if (paramInt == 102) {
      return localActivity.getString(2131364668);
    }
    if (paramInt == 103) {
      return localActivity.getString(2131364675);
    }
    return localActivity.getString(2131364657);
  }
  
  protected String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = 2131364662;
    }
    for (;;)
    {
      if (paramInt != -1) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label81;
        }
      }
      label81:
      for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
      {
        if (localActivity != null)
        {
          return localActivity.getString(paramInt);
          if (paramInt == 1)
          {
            paramInt = 2131364663;
            break;
          }
          if (paramInt < 4)
          {
            paramInt = 2131364664;
            break;
          }
          if (paramInt < 4) {
            break label86;
          }
          paramInt = 2131364665;
          break;
          return null;
        }
        return null;
      }
      label86:
      paramInt = -1;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList, TroopInfoData paramTroopInfoData, QQAppInterface paramQQAppInterface, AccountObserver paramAccountObserver)
  {
    if (paramArrayList == null) {
      return null;
    }
    if ((paramTroopInfoData.troopTypeExt == 2) || (paramTroopInfoData.troopTypeExt == 3) || (paramTroopInfoData.troopTypeExt == 4))
    {
      localObject1 = new ArrayList();
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, localOptions);
        if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100)) {
          ((ArrayList)localObject1).add(str);
        }
      }
      if (((ArrayList)localObject1).size() > 0) {
        QQToast.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 2131365058, 1).a();
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramArrayList.remove((String)((Iterator)localObject1).next());
      }
      if (paramArrayList.size() == 0) {
        return null;
      }
    }
    Object localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      b((String)((Iterator)localObject1).next());
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, paramTroopInfoData.troopUin, "", "", "");
    }
    localObject1 = (AccountManager)paramQQAppInterface.getManager(0);
    Object localObject2 = TroopUtils.a(paramQQAppInterface);
    if (localObject2 == null)
    {
      ((AccountManager)localObject1).updateSKey(paramAccountObserver);
      return paramArrayList;
    }
    TroopUtils.a((String)localObject2, paramQQAppInterface.a(), paramTroopInfoData.troopCode, paramArrayList, this);
    return paramArrayList;
  }
  
  public void a()
  {
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt2);
    if (localObject != null) {
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Int = paramInt1;
    }
    paramInt1 -= this.p;
    while (paramInt1 > 0)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      vsj localvsj = new vsj(this, paramInt2);
      int i1 = o;
      o = i1 + 1;
      ((Handler)localObject).postDelayed(localvsj, i1 * 10);
      paramInt1 -= 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_j_of_type_Int <= 0) {}
    for (;;)
    {
      return;
      this.jdField_j_of_type_Int -= 1;
      Object localObject1 = a(paramInt1);
      if (localObject1 != null)
      {
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_Boolean = false;
        ((AvatarWallAdapter.AvatarInfo)localObject1).d = "AVATAR_URL_STR";
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        }
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean = false;
        Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.g);
        if ((localObject2 != null) && ((((TroopInfo)localObject2).troopTypeExt == 2) || (((TroopInfo)localObject2).troopTypeExt == 4)) && (((TroopInfo)localObject2).isAdmin()))
        {
          ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean = true;
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
          {
            localObject2 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
            if (localObject2 != null)
            {
              DialogUtil.a((Context)localObject2, 230, null, ((Activity)localObject2).getString(2131364677), null, ((Activity)localObject2).getString(2131364678), new DialogUtil.DialogOnClickAdapter(), null).show();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
            }
          }
        }
        paramInt3 = 0x7FFFFFFF & paramInt3;
        if ((paramInt3 < 0) || (paramInt3 > 1))
        {
          this.jdField_i_of_type_Boolean = true;
          a(paramInt2, paramInt1, ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_Boolean);
          notifyDataSetChanged();
          return;
        }
        if ((this.jdField_h_of_type_Boolean) && (paramInt3 >= 0) && (paramInt3 <= 1))
        {
          this.jdField_i_of_type_Boolean = true;
          if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
          for (localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(); localObject1 != null; localObject1 = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.g);
            return;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    Object localObject2;
    String str;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject1).next();
      if (localObject2 != null) {
        str = ((AvatarWallAdapter.AvatarInfo)localObject2).c;
      }
    }
    label346:
    label348:
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str);
        if ((str == null) || (i2 < 0)) {
          break label348;
        }
        if (((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("AVATAR_URL_STR"))
        {
          localArrayList.add(str);
          if (((AvatarWallAdapter.AvatarInfo)localObject2).jdField_b_of_type_Boolean) {
            localHashSet.add(str);
          }
          if (!str.equals(String.valueOf(paramInt1))) {
            break label348;
          }
          i1 = 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i2 = -1;
        continue;
        if ((localArrayList.size() != 0) || (!((AvatarWallAdapter.AvatarInfo)localObject2).d.equals("SYSTEM_PHOTO"))) {
          continue;
        }
        localArrayList.add(str);
        continue;
      }
      if (i1 != 0) {
        b(paramInt2);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label346;
        }
        localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((TroopManager)localObject1).a(String.valueOf(this.g));
        if ((localObject2 == null) || (localArrayList.size() <= 0)) {
          break;
        }
        ((TroopInfo)localObject2).mTroopPicList = localArrayList;
        ((TroopInfo)localObject2).mTroopVerifyingPics = localHashSet;
        ((TroopManager)localObject1).b((TroopInfo)localObject2);
        return;
        localObject1 = a(paramInt2);
        if (localObject1 == null) {
          break;
        }
        ((AvatarWallAdapter.AvatarInfo)localObject1).c = String.valueOf(paramInt1);
        ((AvatarWallAdapter.AvatarInfo)localObject1).d = "AVATAR_URL_STR";
        ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_Boolean = false;
        localArrayList.add(((AvatarWallAdapter.AvatarInfo)localObject1).c);
        if (paramBoolean) {
          localHashSet.add(((AvatarWallAdapter.AvatarInfo)localObject1).c);
        }
      }
      break;
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ProgressBar)paramView.findViewById(2131296302);
      if ((paramView != null) && (paramView.getVisibility() != 8)) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void a(AvatarWallAdapter.AddButtonStatusListener paramAddButtonStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener = paramAddButtonStatusListener;
  }
  
  protected void a(AvatarWallAdapter.ViewHolder paramViewHolder, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    URLImageView localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER);
    ImageView localImageView = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    localImageView.setVisibility(8);
    if (paramInt1 == 1)
    {
      if (localURLImageView.getDrawable() != null) {
        localURLImageView.setImageDrawable(null);
      }
      paramString = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      paramViewHolder = paramString;
      if (paramString == null) {
        paramViewHolder = new FrameLayout.LayoutParams(this.jdField_i_of_type_Int, this.jdField_i_of_type_Int);
      }
      paramViewHolder.gravity = 17;
      if (this.n == 1)
      {
        localImageView.setBackgroundResource(2130840243);
        localImageView.setLayoutParams(paramViewHolder);
        localImageView.setVisibility(0);
      }
    }
    label196:
    label356:
    label364:
    do
    {
      do
      {
        do
        {
          return;
          localImageView.setBackgroundResource(2130840242);
          paramInt1 = (int)UITools.a(paramContext, 30.0F);
          paramViewHolder.width = paramInt1;
          paramViewHolder.height = paramInt1;
          break;
          if (paramInt1 != 0) {
            break label196;
          }
        } while (paramString == null);
        try
        {
          paramViewHolder = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString));
          paramViewHolder.setTag(URLDrawableDecodeHandler.a(this.jdField_i_of_type_Int, this.jdField_i_of_type_Int, 6));
          paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.b);
          localURLImageView.setImageDrawable(paramViewHolder);
          return;
        }
        catch (MalformedURLException paramViewHolder)
        {
          return;
        }
        if (paramInt1 != 2) {
          break label364;
        }
      } while (paramString == null);
      for (;;)
      {
        try
        {
          paramViewHolder = a(paramInt2);
          if (paramViewHolder == null) {
            break;
          }
          if (paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            paramContext = ImageUtil.a(paramString, this.jdField_i_of_type_Int);
            if (paramContext.outHeight <= paramContext.outWidth) {
              break label356;
            }
            paramInt1 = paramContext.outWidth;
            paramViewHolder.jdField_b_of_type_Int = paramInt1;
            paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(paramString, paramContext);
            paramInt1 = TroopUtils.a(paramString);
            if (paramInt1 != 0) {
              paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap, paramInt1);
            }
            paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap, 6.0F, this.jdField_i_of_type_Int, this.jdField_i_of_type_Int);
          }
          if ((paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap == null) || (paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
            break;
          }
          localURLImageView.setImageBitmap(paramViewHolder.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
        }
        catch (OutOfMemoryError paramViewHolder) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramViewHolder.getMessage());
        return;
        paramInt1 = paramContext.outHeight;
      }
    } while (paramInt1 != 3);
    ThreadManager.a(new vsk(this, localURLImageView, paramString), 8, null, false);
  }
  
  public void a(GridView paramGridView)
  {
    paramGridView.setOnItemClickListener(new vsm(this));
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (localActivity == null);
    QQToast.a(localActivity, paramString, 1).b(b());
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_j_of_type_Int <= 0) {
      return;
    }
    this.jdField_j_of_type_Int -= 1;
    if (!a(this.g))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.g);
      this.d = false;
      c();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    b(paramInt);
    a(paramString);
  }
  
  public void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    this.jdField_j_of_type_Int += paramArrayList.size();
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString1, paramString2, paramString3, null);
    c();
  }
  
  public void a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, HashMap paramHashMap)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    this.jdField_j_of_type_Int += paramArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString1, paramString2, paramString3, paramHashMap);
    c();
  }
  
  public void a(List paramList)
  {
    if (this.f) {}
    while (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int i2 = -1;
        try
        {
          i1 = Integer.parseInt(str);
          if ((i1 >= 0) && (i1 < getCount()))
          {
            AvatarWallAdapter.AvatarInfo localAvatarInfo = a(i1);
            if (localAvatarInfo != null)
            {
              if ((localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
              {
                localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
                localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
              }
              if (localAvatarInfo.jdField_a_of_type_Boolean) {
                b(str, o);
              }
              this.jdField_b_of_type_Int -= 1;
              this.jdField_a_of_type_JavaUtilList.remove(i1);
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException.getMessage());
              i1 = i2;
            }
          }
        }
      }
    }
    e();
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3)) {
      c();
    }
    notifyDataSetChanged();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    int i2 = 1;
    if (TroopAvatarManger.jdField_a_of_type_Int != 0) {}
    do
    {
      do
      {
        return;
      } while (this.f);
      localObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 14;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      i1 = 1;
      if (i1 == 0) {
        break label374;
      }
    } while (!paramBoolean);
    Object localObject = new AvatarWallAdapter.AvatarInfo();
    ((AvatarWallAdapter.AvatarInfo)localObject).d = "SYSTEM_PHOTO";
    ((AvatarWallAdapter.AvatarInfo)localObject).c = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
    int i1 = 0;
    for (;;)
    {
      label139:
      label154:
      int i3;
      label211:
      int i4;
      if ((!paramBoolean) && (i1 == 0))
      {
        i2 = 0;
        i1 = 0;
        if (i2 < this.jdField_b_of_type_Int)
        {
          localObject = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i2);
          i3 = i1;
          if (localObject == null) {
            break label436;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).d.equals("AVATAR_URL_STR"))) {
            break label430;
          }
        }
        i2 = 0;
        i3 = 0;
        if (i2 < paramList.size())
        {
          localObject = (AvatarWallAdapter.AvatarInfo)paramList.get(i2);
          i4 = i3;
          if (localObject == null) {
            break label455;
          }
          if ((!((AvatarWallAdapter.AvatarInfo)localObject).jdField_a_of_type_Boolean) || (((AvatarWallAdapter.AvatarInfo)localObject).d.equals("AVATAR_URL_STR"))) {
            break label449;
          }
        }
        if (a(this.jdField_a_of_type_JavaUtilList, paramList, i1, i3)) {
          break label468;
        }
        paramList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, i1));
        if (!a(paramList, i1)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        e();
        if (this.c) {
          c();
        }
        notifyDataSetChanged();
        paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        paramList.what = 14;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
        return;
        i1 = 0;
        break;
        label374:
        if ((this.jdField_b_of_type_Int <= getCount()) && (this.jdField_a_of_type_JavaUtilList != null)) {
          break label487;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Int);
        i1 = i2;
        break label139;
        label430:
        i3 = i1 + 1;
        label436:
        i2 += 1;
        i1 = i3;
        break label154;
        label449:
        i4 = i3 + 1;
        label455:
        i2 += 1;
        i3 = i4;
        break label211;
        label468:
        this.jdField_a_of_type_JavaUtilList = paramList;
        a(this.jdField_a_of_type_JavaUtilList, i3);
      }
      label487:
      i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = paramActivity.getResources().getStringArray(2131230742);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramActivity, null);
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i1] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]]);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((paramArrayOfInt[i1] >= 0) && (paramArrayOfInt[i1] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]], 1);
        }
      }
    }
    localActionSheet.a(new vsn(this, paramActivity, localActionSheet));
    localActionSheet.show();
  }
  
  public boolean a(int paramInt)
  {
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt);
    if (localAvatarInfo != null) {
      return localAvatarInfo.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_j_of_type_Int != 0;
  }
  
  protected boolean a(List paramList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    int i1;
    Object localObject;
    Iterator localIterator;
    if (paramInt == 8)
    {
      i1 = 1;
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
      if (paramList != null) {
        localIterator = paramList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label170;
        }
        UploadItem localUploadItem = (UploadItem)localIterator.next();
        if (localUploadItem != null)
        {
          if (paramInt == 8) {
            i1 = 1;
          }
          if (i1 == 0)
          {
            AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
            localAvatarInfo.jdField_b_of_type_JavaLangString = localUploadItem.jdField_a_of_type_JavaLangString;
            localAvatarInfo.jdField_a_of_type_Int = localUploadItem.jdField_a_of_type_Int;
            localAvatarInfo.d = "AVATAR_LOCAL_STR";
            localAvatarInfo.jdField_a_of_type_Boolean = true;
            ((List)localObject).add(paramInt, localAvatarInfo);
            paramInt += 1;
            continue;
            i1 = 0;
            break;
          }
          localIterator.remove();
        }
      }
      label170:
      this.jdField_j_of_type_Int = paramList.size();
    }
    return paramList != null;
  }
  
  protected boolean a(List paramList1, List paramList2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      return true;
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo1 = (AvatarWallAdapter.AvatarInfo)paramList1.get(paramInt2);
      AvatarWallAdapter.AvatarInfo localAvatarInfo2 = (AvatarWallAdapter.AvatarInfo)paramList2.get(paramInt2);
      String str1;
      String str2;
      if (localAvatarInfo1 != null)
      {
        str1 = localAvatarInfo1.c;
        if (localAvatarInfo2 != null)
        {
          str2 = localAvatarInfo2.c;
          if (str1 != null) {
            break label78;
          }
          return true;
        }
      }
      else
      {
        return true;
      }
      return false;
      label78:
      if (((str2 != null) && (!str2.equals(str1))) || (localAvatarInfo1.jdField_b_of_type_Boolean != localAvatarInfo2.jdField_b_of_type_Boolean)) {
        return true;
      }
      paramInt2 += 1;
    }
    return false;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return 0;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localActivity != null) {
      return localActivity.getResources().getDimensionPixelSize(2131492908);
    }
    return 0;
  }
  
  public int b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(paramString1);
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i1 = paramString1.read(arrayOfByte);
        if (i1 <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i1);
      }
      paramString1.close();
      paramString2.close();
      return 0;
    }
    catch (Exception paramString1) {}
    return -1;
  }
  
  public void b()
  {
    if (this.f) {
      return;
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Int <= getCount()))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, this.jdField_b_of_type_Int));
      e();
    }
    if (this.c) {
      c();
    }
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    AvatarWallAdapter.AvatarInfo localAvatarInfo;
    do
    {
      return;
      localAvatarInfo = a(paramInt);
    } while (localAvatarInfo == null);
    if ((localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int -= 1;
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 4)) {
        c();
      }
      notifyDataSetChanged();
      return;
      localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
      if (this.jdField_b_of_type_Int == 8)
      {
        localAvatarInfo.d = "PLUS";
        this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt1);
    if (localAvatarInfo != null)
    {
      if (paramInt1 >= paramInt2) {
        break label57;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramInt2 + 1, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return;
      label57:
      this.jdField_a_of_type_JavaUtilList.add(paramInt2, (AvatarWallAdapter.AvatarInfo)localAvatarInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramInt1 + 1);
    }
  }
  
  public void b(String paramString)
  {
    if (this.f) {}
    while (paramString == null) {
      return;
    }
    AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
    localAvatarInfo.jdField_b_of_type_JavaLangString = paramString;
    localAvatarInfo.d = "AVATAR_LOCAL_STR";
    localAvatarInfo.jdField_a_of_type_Boolean = true;
    localAvatarInfo.c = "-1";
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, localAvatarInfo);
    this.jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_Int == 8) && (this.jdField_a_of_type_JavaUtilList.size() == 9)) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_b_of_type_Int);
    }
    notifyDataSetChanged();
  }
  
  protected void b(String paramString, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "upload_head_cancel", 0, 0, this.g, "0", "", "");
    AvatarWallAdapter.AvatarInfo localAvatarInfo = a(paramInt);
    if ((localAvatarInfo == null) || (paramString == null)) {
      return;
    }
    if (localAvatarInfo.c == null)
    {
      this.jdField_j_of_type_Int -= 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(paramString);
      return;
    }
    try
    {
      paramInt = Integer.parseInt(localAvatarInfo.c);
      paramString = new ArrayList();
      paramString.add(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.g, 2, paramString);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void c()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).a(String.valueOf(this.g));
      localObject2 = new TroopInfoData();
      ((TroopInfoData)localObject2).updateForTroopInfo((TroopInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (boolean bool = ((TroopInfoData)localObject2).isHideTroop();; bool = false)
    {
      if (bool) {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label149;
        }
      }
      label149:
      for (localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localObject1 = null)
      {
        if (localObject1 != null) {
          localObject1 = ((Activity)localObject1).getString(2131364824);
        }
        for (;;)
        {
          if ((localObject1 != null) && (this.jdField_b_of_type_AndroidOsHandler != null))
          {
            localObject2 = new Message();
            ((Message)localObject2).what = 11;
            ((Message)localObject2).obj = localObject1;
            this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
          return;
          localObject1 = a(this.jdField_b_of_type_Int, this.d);
          continue;
          localObject1 = null;
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < getCount()))
    {
      b(paramInt, 0);
      f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    this.f = true;
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_Int)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = a(i1);
      if ((localAvatarInfo != null) && (localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        localAvatarInfo.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a();
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void d(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_a_of_type_ComTencentWidgetGridView.c())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_a_of_type_ComTencentWidgetGridView.z() * paramInt + (paramInt - 1) * this.jdField_a_of_type_ComTencentWidgetGridView.b_() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label123;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label141;
      }
    }
    label123:
    label141:
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if ((localActivity == null) || (Thread.currentThread() == localActivity.getMainLooper().getThread())) {
        break label155;
      }
      localActivity.runOnUiThread(new vso(this, paramInt, localLayoutParams));
      return;
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break;
      }
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      break;
    }
    label155:
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
    this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
  }
  
  protected void e()
  {
    if ((this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < 8)) {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        while (i1 >= 0)
        {
          localAvatarInfo = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localAvatarInfo != null) && (localAvatarInfo.d.equals("PLUS"))) {
            this.jdField_a_of_type_JavaUtilList.remove(localAvatarInfo);
          }
          i1 -= 1;
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null) {
          break label118;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
      }
    }
    label118:
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener == null)
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo;
      do
      {
        int i1;
        return;
        localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
      } while ((!this.c) || (!this.k));
      localAvatarInfo.d = "PLUS";
      this.jdField_a_of_type_JavaUtilList.add(localAvatarInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AddButtonStatusListener.a(false);
  }
  
  public void e(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void f()
  {
    if (this.f) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)localIterator.next();
      if ((localAvatarInfo != null) && (localAvatarInfo.d.equals("AVATAR_URL_STR"))) {
        localArrayList.add(Integer.valueOf(Integer.parseInt(localAvatarInfo.c)));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.g, 0, localArrayList);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_h_of_type_JavaLangString, "drag_head", 0, 0, this.g, "", "", "");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {}
    for (Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; localActivity = null)
    {
      if (localActivity == null) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[s];
      }
      this.jdField_a_of_type_ArrayOfInt[0] = 13;
      this.jdField_a_of_type_ArrayOfInt[1] = 14;
      this.jdField_a_of_type_ArrayOfInt[2] = 16;
      int i1 = 3;
      while (i1 < s)
      {
        this.jdField_a_of_type_ArrayOfInt[i1] = -1;
        i1 += 1;
      }
      a(this.jdField_a_of_type_ArrayOfInt, localActivity);
      return;
    }
  }
  
  public int getCount()
  {
    int i2 = 4;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i1 = this.jdField_a_of_type_JavaUtilList.size();; i1 = 0)
    {
      if (i1 < 4) {
        i2 = i1;
      }
      d(i2);
      return i1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = 1;
    Activity localActivity = null;
    paramViewGroup = paramView;
    if (paramView == null) {
      if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
        break label678;
      }
    }
    label270:
    label368:
    label633:
    label642:
    label663:
    label670:
    label678:
    for (paramViewGroup = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();; paramViewGroup = null)
    {
      if (paramViewGroup == null) {}
      AvatarWallAdapter.AvatarInfo localAvatarInfo;
      do
      {
        return paramView;
        paramViewGroup = LayoutInflater.from(paramViewGroup).inflate(2130903650, null);
        localAvatarInfo = a(paramInt);
        paramView = paramViewGroup;
      } while (localAvatarInfo == null);
      paramView = localAvatarInfo.d;
      if (paramView.equals("PLUS")) {
        paramView = null;
      }
      for (;;)
      {
        AvatarWallAdapter.ViewHolder localViewHolder;
        if (paramViewGroup.getTag() == null)
        {
          localViewHolder = new AvatarWallAdapter.ViewHolder(this);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131299581));
          localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296302));
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131296844));
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          localLayoutParams.height = this.jdField_i_of_type_Int;
          localLayoutParams.width = this.jdField_i_of_type_Int;
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
          localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams.height = this.jdField_i_of_type_Int;
          localLayoutParams.width = this.jdField_i_of_type_Int;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
          localLayoutParams = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
          localLayoutParams.height = this.jdField_i_of_type_Int;
          localLayoutParams.width = this.jdField_i_of_type_Int;
          localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
          paramViewGroup.setTag(localViewHolder);
          if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
            localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          }
          if (localActivity != null)
          {
            paramViewGroup.setContentDescription(localActivity.getString(2131364656));
            a(localViewHolder, localActivity, i1, paramView, paramInt);
          }
          paramView = localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar;
          if (!localAvatarInfo.jdField_a_of_type_Boolean) {
            break label633;
          }
          if (paramView.getVisibility() != 0) {
            paramView.setVisibility(0);
          }
          paramView.setProgress(localAvatarInfo.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
          paramView.setProgress(100);
          if (!localAvatarInfo.jdField_b_of_type_Boolean) {
            break label642;
          }
          if (localViewHolder.jdField_a_of_type_AndroidViewView == null)
          {
            localViewHolder.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131299582)).inflate();
            paramView = (FrameLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
            paramView.height = this.jdField_i_of_type_Int;
            paramView.width = this.jdField_i_of_type_Int;
            localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(paramView);
            paramViewGroup.setTag(localViewHolder);
          }
          localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        for (;;)
        {
          if ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
            break label663;
          }
          paramViewGroup.setVisibility(8);
          return paramViewGroup;
          if ((paramView.equals("AVATAR_URL_STR")) && ((localAvatarInfo.jdField_b_of_type_JavaLangString == null) || (!new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
          {
            paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.c, this.g, 1));
            i1 = 0;
            break;
          }
          if ((paramView.equals("AVATAR_LOCAL_STR")) || ((localAvatarInfo.jdField_b_of_type_JavaLangString != null) && (new File(localAvatarInfo.jdField_b_of_type_JavaLangString).exists())))
          {
            paramView = localAvatarInfo.jdField_b_of_type_JavaLangString;
            i1 = 2;
            break;
          }
          if (!paramView.equals("SYSTEM_PHOTO")) {
            break label670;
          }
          paramView = AvatarTroopUtil.a(AvatarTroopUtil.a(localAvatarInfo.c, this.g, 0));
          i1 = 3;
          break;
          localViewHolder = (AvatarWallAdapter.ViewHolder)paramViewGroup.getTag();
          break label270;
          paramView.setVisibility(8);
          break label368;
          if (localViewHolder.jdField_a_of_type_AndroidViewView != null) {
            localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        paramViewGroup.setVisibility(0);
        return paramViewGroup;
        paramView = null;
        i1 = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\AvatarWallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */