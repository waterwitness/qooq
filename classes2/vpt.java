import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFileListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class vpt
  extends TroopFileProtocol.GetFileListObserver
{
  public vpt(TroopFileManager paramTroopFileManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List arg7, Bundle paramBundle)
  {
    int i;
    String str;
    long l;
    label393:
    label400:
    Object localObject1;
    for (;;)
    {
      boolean bool;
      try
      {
        i = paramBundle.getInt("reqFor");
        bool = paramBundle.getBoolean("isFirstPage");
        str = paramBundle.getString("parentFileId");
        l = paramBundle.getLong("uin_filter");
        paramBundle = (TroopFileManager.FileManagerStatus)this.a.d.get(str + l);
        if (paramBundle == null) {
          return;
        }
        if (i != 1) {
          break label400;
        }
        if (paramInt2 != 64536) {
          break label393;
        }
        if (paramBoolean1) {
          break label2551;
        }
        if (!QLog.isDevelopLevel()) {
          break label2520;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i);
      }
      finally {}
      paramBundle.jdField_a_of_type_Long = 0L;
      this.a.a(null, false, str, l);
      continue;
      paramBundle.jdField_b_of_type_Boolean = false;
      this.a.a(null, false, str, l);
      continue;
      if (paramBundle.jdField_a_of_type_JavaUtilList != null) {
        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
        {
          paramBundle.d += 1;
          this.a.b(str, l);
        }
        else
        {
          paramBundle.d = 0;
          this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
          continue;
          if (paramBundle.jdField_a_of_type_JavaUtilList != null) {
            if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
            {
              paramBundle.d += 1;
              paramBundle.jdField_b_of_type_Boolean = false;
              this.a.b(str, l);
            }
            else
            {
              paramBundle.jdField_b_of_type_Boolean = false;
              paramBundle.d = 0;
              this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
              continue;
              try
              {
                paramBundle.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramByteStringMicro;
                if ((!paramBoolean1) || (??? == null))
                {
                  if (paramBoolean1) {
                    break label2615;
                  }
                  if (!QLog.isDevelopLevel()) {
                    break label2583;
                  }
                  QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i);
                  break label2583;
                  paramBundle.jdField_a_of_type_Long = 0L;
                  this.a.a(null, false, str, l);
                  continue;
                  paramBundle.jdField_b_of_type_Boolean = false;
                  this.a.a(null, false, str, l);
                  continue;
                  if (paramBundle.jdField_a_of_type_JavaUtilList != null) {
                    if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
                    {
                      paramBundle.d += 1;
                      this.a.b(str, l);
                    }
                    else
                    {
                      paramBundle.d = 0;
                      this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
                      continue;
                      if (paramBundle.jdField_a_of_type_JavaUtilList != null) {
                        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
                        {
                          paramBundle.d += 1;
                          paramBundle.jdField_b_of_type_Boolean = false;
                          this.a.b(str, l);
                        }
                        else
                        {
                          paramBundle.jdField_b_of_type_Boolean = false;
                          paramBundle.d = 0;
                          this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
                        }
                      }
                    }
                  }
                }
                else
                {
                  paramBundle.jdField_a_of_type_Boolean = paramBoolean2;
                  paramBundle.jdField_b_of_type_Int = paramInt3;
                  if (!bool) {
                    break label869;
                  }
                  paramBundle.jdField_a_of_type_Int = paramInt1;
                  paramByteStringMicro = this.a.b();
                  paramBundle.jdField_a_of_type_JavaUtilList.clear();
                  paramBundle.jdField_a_of_type_JavaUtilMap.clear();
                  paramByteStringMicro = paramByteStringMicro.iterator();
                  while (paramByteStringMicro.hasNext())
                  {
                    localObject1 = (TroopFileInfo)paramByteStringMicro.next();
                    this.a.b.put(((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
                    this.a.c.put(((TroopFileInfo)localObject1).b, localObject1);
                  }
                  if (!QLog.isDevelopLevel()) {
                    break label2647;
                  }
                }
              }
              finally
              {
                if (paramBoolean1) {
                  break label2755;
                }
              }
            }
          }
        }
      }
    }
    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i);
    for (;;)
    {
      label866:
      throw paramByteStringMicro;
      label869:
      Object localObject2;
      switch (i)
      {
      case 2: 
      default: 
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a();
        localObject2 = ???.iterator();
      }
      label1408:
      label1569:
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label1571;
        }
        paramByteStringMicro = (TroopFileInfo)((Iterator)localObject2).next();
        if (paramByteStringMicro.jdField_d_of_type_Boolean)
        {
          if (paramByteStringMicro.b == null) {
            continue;
          }
          ??? = (TroopFileInfo)this.a.c.get(paramByteStringMicro.b);
          if (??? == null)
          {
            paramByteStringMicro.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
            this.a.c.put(paramByteStringMicro.b, paramByteStringMicro);
            Iterator localIterator = ((List)localObject1).iterator();
            for (;;)
            {
              ??? = paramByteStringMicro;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (TroopFileStatusInfo)localIterator.next();
              if (paramByteStringMicro.b.equals(???.i))
              {
                TroopFileInfo localTroopFileInfo = new TroopFileInfo();
                localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = ???.jdField_a_of_type_JavaUtilUUID;
                localTroopFileInfo.b = ???.e;
                localTroopFileInfo.f = ???.i;
                localTroopFileInfo.a(???, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                paramByteStringMicro.a(localTroopFileInfo);
              }
            }
            paramBundle.jdField_a_of_type_Boolean = paramBoolean2;
            break;
          }
          ???.b(paramByteStringMicro);
          this.a.b.put(???.jdField_a_of_type_JavaUtilUUID, ???);
          if (paramBundle.jdField_a_of_type_JavaUtilMap.get(???.b) == null)
          {
            paramBundle.jdField_a_of_type_JavaUtilList.add(???);
            paramBundle.jdField_a_of_type_JavaUtilMap.put(???.b, ???);
          }
          this.a.c.put(???.b, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + paramByteStringMicro.jdField_c_of_type_JavaLangString + ", filePath = " + paramByteStringMicro.b + ", sha = " + paramByteStringMicro.jdField_d_of_type_JavaLangString);
        }
        ??? = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramByteStringMicro.b);
        if (??? == null)
        {
          paramByteStringMicro.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
          paramByteStringMicro.jdField_d_of_type_Long = paramByteStringMicro.jdField_c_of_type_Long;
        }
        for (;;)
        {
          if ((paramByteStringMicro.e == 1) || (paramByteStringMicro.e == 3) || (paramByteStringMicro.e == 2) || (paramByteStringMicro.e == 12)) {
            break label1569;
          }
          ??? = (TroopFileInfo)this.a.c.get(paramByteStringMicro.b);
          if (??? == null) {
            break label2679;
          }
          ???.b(paramByteStringMicro);
          paramByteStringMicro = ???;
          this.a.b.put(paramByteStringMicro.jdField_a_of_type_JavaUtilUUID, paramByteStringMicro);
          if (paramBundle.jdField_a_of_type_JavaUtilMap.get(paramByteStringMicro.b) == null)
          {
            paramBundle.jdField_a_of_type_JavaUtilList.add(paramByteStringMicro);
            paramBundle.jdField_a_of_type_JavaUtilMap.put(paramByteStringMicro.b, paramByteStringMicro);
          }
          this.a.c.put(paramByteStringMicro.b, paramByteStringMicro);
          break;
          paramByteStringMicro.jdField_a_of_type_JavaUtilUUID = ???.jdField_a_of_type_JavaUtilUUID;
          paramByteStringMicro.a(???, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramByteStringMicro.e == 9)
          {
            ??? = (TroopFileInfo)this.a.c.get(???.i);
            if (??? != null) {
              ???.a(paramByteStringMicro);
            }
          }
        }
      }
      label1571:
      int j;
      if (!"/".equals(str))
      {
        paramByteStringMicro = (TroopFileInfo)this.a.c.get(str);
        if (paramByteStringMicro != null)
        {
          ??? = paramByteStringMicro.jdField_a_of_type_JavaUtilMap.keySet();
          localObject1 = new ArrayList();
          ??? = ???.iterator();
          while (???.hasNext()) {
            ((List)localObject1).add((String)???.next());
          }
          j = paramBundle.jdField_a_of_type_JavaUtilList.size();
        }
      }
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager)
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            paramInt2 = 0;
            paramInt1 = 0;
            localObject2 = (TroopFileInfo)paramByteStringMicro.jdField_a_of_type_JavaUtilMap.get(localObject2);
            if (localObject2 == null) {
              continue;
            }
            if ((j <= 0) || (paramBundle.jdField_a_of_type_JavaUtilList.get(j - 1) == null)) {
              break label2515;
            }
            int k = ((TroopFileInfo)paramBundle.jdField_a_of_type_JavaUtilList.get(j - 1)).a();
            if (((TroopFileInfo)localObject2).a() >= k)
            {
              paramInt3 = 0;
              paramInt2 = paramInt1;
              if (paramInt3 < j)
              {
                if ((localObject2 == null) || (((TroopFileInfo)localObject2).b == null) || (paramBundle.jdField_a_of_type_JavaUtilList.get(paramInt3) == null) || (!((TroopFileInfo)localObject2).b.equals(((TroopFileInfo)paramBundle.jdField_a_of_type_JavaUtilList.get(paramInt3)).b))) {
                  break label2512;
                }
                paramInt1 = 1;
                break label2682;
              }
            }
            paramInt1 = paramInt2;
            if (((TroopFileInfo)localObject2).a() <= k)
            {
              paramInt1 = paramInt2;
              if (!paramBoolean2) {
                paramInt1 = 1;
              }
            }
            if (paramInt1 != 0) {
              continue;
            }
            paramByteStringMicro.jdField_a_of_type_JavaUtilMap.remove(((TroopFileInfo)localObject2).b);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b.remove(((TroopFileInfo)localObject2).jdField_a_of_type_JavaUtilUUID);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f();
        this.a.d(paramByteStringMicro);
        if (paramBoolean1) {
          break label2723;
        }
        if (!QLog.isDevelopLevel()) {
          break label2691;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i);
        break label2691;
        paramBundle.jdField_a_of_type_Long = 0L;
        this.a.a(null, false, str, l);
        break;
        paramBundle.jdField_b_of_type_Boolean = false;
        this.a.a(null, false, str, l);
        break;
        if (paramBundle.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
        {
          paramBundle.d += 1;
          this.a.b(str, l);
          break;
        }
        paramBundle.d = 0;
        this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
        break;
        if (paramBundle.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
        {
          paramBundle.d += 1;
          paramBundle.jdField_b_of_type_Boolean = false;
          this.a.b(str, l);
          break;
        }
        paramBundle.jdField_b_of_type_Boolean = false;
        paramBundle.d = 0;
        this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
        break;
        paramBundle.jdField_a_of_type_Long = 0L;
        this.a.a(null, false, str, l);
        break label866;
        paramBundle.jdField_b_of_type_Boolean = false;
        this.a.a(null, false, str, l);
        break label866;
        if (paramBundle.jdField_a_of_type_JavaUtilList == null) {
          break label866;
        }
        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
        {
          paramBundle.d += 1;
          this.a.b(str, l);
          break label866;
        }
        paramBundle.d = 0;
        this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
        break label866;
        if (paramBundle.jdField_a_of_type_JavaUtilList == null) {
          break label866;
        }
        if ((paramBundle.jdField_a_of_type_JavaUtilList.size() < 15) && (!paramBundle.jdField_a_of_type_Boolean) && (paramBundle.d <= 3))
        {
          paramBundle.d += 1;
          paramBundle.jdField_b_of_type_Boolean = false;
          this.a.b(str, l);
          break label866;
        }
        paramBundle.jdField_b_of_type_Boolean = false;
        paramBundle.d = 0;
        this.a.a(paramBundle.jdField_a_of_type_JavaUtilList, paramBundle.jdField_a_of_type_Boolean, str, l);
        break label866;
        label2512:
        break label2682;
        label2515:
        paramInt1 = 0;
        continue;
        label2520:
        switch (i)
        {
        }
        break;
        label2551:
        switch (i)
        {
        }
        break;
        label2583:
        switch (i)
        {
        }
        break;
        label2615:
        switch (i)
        {
        }
        break;
        label2647:
        switch (i)
        {
        }
        break label866;
        label2679:
        break label1408;
        label2682:
        paramInt3 += 1;
      }
      label2691:
      switch (i)
      {
      }
      break;
      label2723:
      switch (i)
      {
      }
      break;
      label2755:
      switch (i)
      {
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */