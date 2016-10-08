import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class iax
  implements Runnable
{
  public iax(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
      return;
    }
    int i;
    label26:
    LinkedList localLinkedList;
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      localLinkedList = new LinkedList();
      j = this.jdField_a_of_type_Int;
      label40:
      if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
        break label594;
      }
      if ((j < i) && (j >= 0)) {
        break label89;
      }
    }
    label66:
    label89:
    Object localObject2;
    int k;
    label203:
    Object localObject1;
    label229:
    Object localObject3;
    for (;;)
    {
      j += 1;
      break label40;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break label26;
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(j)).longValue());
          k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItemViewType(j);
          if (k != 4) {
            break label229;
          }
          if (((BaseArticleInfo)localObject2).mVideoCoverUrl == null) {
            break label203;
          }
          URL localURL = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
          localLinkedList.add(ibv.a(localURL, ReadInJoyDisplayUtils.b()));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) == this.jdField_a_of_type_Long) {
          break;
        }
        return;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null) {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
        } else {
          localObject1 = ReadInJoyUtils.b(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        }
      }
      if (k != 3) {
        break label762;
      }
      if ((((BaseArticleInfo)localObject2).mPictures == null) || (((BaseArticleInfo)localObject2).mPictures.length <= 0))
      {
        localObject3 = ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, ((BaseArticleInfo)localObject2).mJsonPictureList, "pictures");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          localObject1 = ((JSONArray)localObject3).optJSONObject(0);
          if (localObject1 == null)
          {
            localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;
            label294:
            localLinkedList.add(ibv.a(ReadInJoyUtils.b((String)localObject1), ReadInJoyDisplayUtils.a()));
            localObject1 = ((JSONArray)localObject3).optJSONObject(1);
            if (localObject1 != null) {
              break label390;
            }
            localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;
            label327:
            localLinkedList.add(ibv.a(ReadInJoyUtils.b((String)localObject1), ReadInJoyDisplayUtils.a()));
            localObject1 = ((JSONArray)localObject3).optJSONObject(2);
            if (localObject1 != null) {
              break label400;
            }
          }
          label390:
          label400:
          for (localObject1 = ((BaseArticleInfo)localObject2).mFirstPagePicUrl;; localObject1 = ((JSONObject)localObject1).optString("picture"))
          {
            localLinkedList.add(ibv.a(ReadInJoyUtils.b((String)localObject1), ReadInJoyDisplayUtils.a()));
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label294;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label327;
          }
        }
      }
      else
      {
        if ((((BaseArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          label433:
          localLinkedList.add(ibv.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          if ((((BaseArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label534;
          }
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          label470:
          localLinkedList.add(ibv.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          if ((((BaseArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label544;
          }
        }
        label534:
        label544:
        for (localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;; localObject1 = localObject2.mPictures[2])
        {
          localLinkedList.add(ibv.a((URL)localObject1, ReadInJoyDisplayUtils.a()));
          break;
          localObject1 = localObject2.mPictures[0];
          break label433;
          localObject1 = localObject2.mPictures[1];
          break label470;
        }
        label554:
        localLinkedList.add(ibv.a(((BaseArticleInfo)localObject2).mSinglePicture, ReadInJoyDisplayUtils.b()));
      }
    }
    for (;;)
    {
      localLinkedList.add(ibv.a(((BaseArticleInfo)localObject2).mSinglePicture, ReadInJoyDisplayUtils.a()));
      break label66;
      label594:
      if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) != this.jdField_a_of_type_Long) {
        break;
      }
      localObject1 = localLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ibv)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ibv)localObject2).jdField_a_of_type_JavaNetURL != null))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = ((Integer)((ibv)localObject2).jdField_a_of_type_AndroidUtilPair.first).intValue();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((Integer)((ibv)localObject2).jdField_a_of_type_AndroidUtilPair.second).intValue();
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          URLDrawable.getDrawable(((ibv)localObject2).jdField_a_of_type_JavaNetURL, (URLDrawable.URLDrawableOptions)localObject3).startDownload(true);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      return;
      label762:
      if ((k == 2) || (k == 6)) {
        break label554;
      }
      if (k != 1) {
        if (k != 5) {
          break label66;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */