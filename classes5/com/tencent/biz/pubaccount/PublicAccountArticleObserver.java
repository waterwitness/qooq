package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class PublicAccountArticleObserver
  implements BusinessObserver
{
  public static final String a = "Q.pubaccount.video.PublicAccountArticleObserver";
  
  public PublicAccountArticleObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ArrayList localArrayList1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        a(true, ((Bundle)paramObject).getString("VALUE_ARTICLE_ID"), ((Bundle)paramObject).getInt("VALUE_ARTICLE_LIKE_COUNT"));
        return;
      }
      a(false, null, 0);
      return;
    case 0: 
      if ((paramObject != null) && ((paramObject instanceof Bundle)))
      {
        a(paramBoolean, ((Bundle)paramObject).getString("VALUE_ARTICLE_ID"));
        return;
      }
      a(false, null);
      return;
    case 1: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        a(true, ((Bundle)paramObject).getString("VALUE_ARTICLE_ID"), Boolean.valueOf(((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IS_LIKED")).booleanValue());
        return;
      }
      a(false, null, false);
      return;
    case 3: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
        {
          a(true);
          return;
        }
        a(false);
        return;
      }
      a(false);
      return;
    case 4: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
        {
          a(true, ((Bundle)paramObject).getInt("VALUE_ARTICLE_COMMENT_COUNT"));
          return;
        }
        a(false, 0);
        return;
      }
      a(false, 0);
      return;
    case 5: 
      localArrayList1 = new ArrayList();
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        Object localObject5 = (Bundle)paramObject;
        long l = ((Bundle)localObject5).getLong("VALUE_ARTICLE_PUIN");
        paramObject = "" + l;
        localObject1 = ((Bundle)localObject5).getString("VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS");
        localObject2 = ((Bundle)localObject5).getString("VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL");
        localObject3 = ((Bundle)localObject5).getString("VALUE_ARTICLE_ITEM_COLLECTION_TITLE");
        paramBoolean = ((Bundle)localObject5).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
        int i = ((Bundle)localObject5).getInt("VALUE_ARTICLE_ITEM_RECOMMEND_CAN");
        localObject4 = ((Bundle)localObject5).getString("VALUE_ARTICLE_ITEM_COMMENT_URL");
        ArrayList localArrayList2 = ((Bundle)localObject5).getStringArrayList("VALUE_ARTICLE_ITEM_URLS");
        localObject5 = ((Bundle)localObject5).getStringArrayList("VALUE_ARTICLE_ITEM_CONTENTS");
        if (localArrayList2 != null)
        {
          paramInt = 0;
          while (paramInt < localArrayList2.size())
          {
            PublicAccountArticleObserver.PhotoItemInfo localPhotoItemInfo = new PublicAccountArticleObserver.PhotoItemInfo();
            localPhotoItemInfo.jdField_a_of_type_JavaLangString = ((String)localArrayList2.get(paramInt));
            localPhotoItemInfo.b = ((String)((ArrayList)localObject5).get(paramInt));
            localArrayList1.add(localPhotoItemInfo);
            paramInt += 1;
          }
        }
        if (paramBoolean)
        {
          a(true, (String)localObject1, (String)paramObject, localArrayList1, (String)localObject2, (String)localObject3, i, (String)localObject4);
          return;
        }
        a(false, (String)localObject1, (String)paramObject, localArrayList1, (String)localObject2, (String)localObject3, i, (String)localObject4);
        return;
      }
      a(false, "", "", localArrayList1, "", "", 0, "");
      return;
    case 6: 
      localArrayList1 = new ArrayList();
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        localObject3 = (Bundle)paramObject;
        paramBoolean = ((Bundle)localObject3).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false);
        paramObject = ((Bundle)localObject3).getStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_URLS");
        localObject1 = ((Bundle)localObject3).getStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_TITLES");
        localObject2 = ((Bundle)localObject3).getIntegerArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE");
        localObject3 = ((Bundle)localObject3).getStringArrayList("VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID");
        if (paramObject != null)
        {
          paramInt = 0;
          while (paramInt < ((ArrayList)paramObject).size())
          {
            localObject4 = new PublicAccountArticleObserver.RecommendItemInfo();
            ((PublicAccountArticleObserver.RecommendItemInfo)localObject4).jdField_a_of_type_JavaLangString = ((String)((ArrayList)paramObject).get(paramInt));
            ((PublicAccountArticleObserver.RecommendItemInfo)localObject4).b = ((String)((ArrayList)localObject1).get(paramInt));
            ((PublicAccountArticleObserver.RecommendItemInfo)localObject4).jdField_a_of_type_Int = ((Integer)((ArrayList)localObject2).get(paramInt)).intValue();
            ((PublicAccountArticleObserver.RecommendItemInfo)localObject4).c = ((String)((ArrayList)localObject3).get(paramInt));
            localArrayList1.add(localObject4);
            paramInt += 1;
          }
        }
        if (paramBoolean)
        {
          a(true, localArrayList1);
          return;
        }
        a(false, localArrayList1);
        return;
      }
      a(false, localArrayList1);
      return;
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
      {
        b(true);
        return;
      }
      b(false);
      return;
    }
    b(false);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt, String paramString5) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountArticleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */