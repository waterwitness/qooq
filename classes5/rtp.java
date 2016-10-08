import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class rtp
  implements Runnable
{
  rtp(rto paramrto, HashMap paramHashMap1, HashMap paramHashMap2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if ((QfileLocalFileMediaTabView.a(this.jdField_a_of_type_Rto.a) & 0x2) > 0) {
      this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("Camera", new ArrayList());
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的视频")) {
        this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的视频", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的视频")).addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
      if (!this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_JavaUtilHashMap.get(localObject2))) {
        this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2));
      }
    }
    localObject1 = this.b.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的音乐")) {
        this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的音乐", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的音乐")).addAll((Collection)this.b.get(localObject2));
      if (!this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilArrayList.contains(this.b.get(localObject2))) {
        this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)this.b.get(localObject2));
      }
    }
    Object localObject2 = this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    FileInfo localFileInfo;
    while (((Iterator)localObject2).hasNext())
    {
      localFileInfo = (FileInfo)((Iterator)localObject2).next();
      localObject1 = localFileInfo.a();
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        if ((((String)localObject1).equalsIgnoreCase("camera") != true) && (((String)localObject1).equalsIgnoreCase("Video") != true)) {
          break label557;
        }
        localObject1 = "Camera";
      }
    }
    label557:
    for (;;)
    {
      if (!this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject1)) {
        this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
      }
      if (((List)this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).contains(localFileInfo)) {
        break;
      }
      ((List)this.jdField_a_of_type_Rto.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localFileInfo);
      break;
      this.jdField_a_of_type_Rto.a.j();
      this.jdField_a_of_type_Rto.a.setSelect(0);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */