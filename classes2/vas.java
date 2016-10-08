import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider.PttIpList;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class vas
{
  private static final int jdField_a_of_type_Int = 5;
  private static final int b = 2;
  private Random jdField_a_of_type_JavaUtilRandom;
  private int[][] jdField_a_of_type_Array2dOfInt;
  
  public vas(FMTSrvAddrProvider paramFMTSrvAddrProvider)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  }
  
  private int a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = 5;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt()) % localArrayList.size())).intValue();
      }
    }
    return -1;
  }
  
  private int b(int[] paramArrayOfInt)
  {
    if (!FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider).a()) {}
    for (int i = 2;; i = 5)
    {
      if (paramArrayOfInt != null)
      {
        int j = 0;
        while (j < paramArrayOfInt.length)
        {
          if (paramArrayOfInt[j] < i) {
            return j;
          }
          j += 1;
        }
      }
      return -1;
    }
  }
  
  public FileStorageServerListInfo a()
  {
    Object localObject2 = null;
    ArrayList localArrayList = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, 16);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        int i = b(FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider).a(FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider).b()));
        localObject1 = localObject2;
        if (i > -1)
        {
          localObject1 = localObject2;
          if (i < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(i);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return (FileStorageServerListInfo)localObject1;
  }
  
  public FileStorageServerListInfo a(int paramInt)
  {
    Object localObject2 = null;
    ArrayList localArrayList = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        paramInt = a(a(paramInt));
        localObject1 = localObject2;
        if (paramInt > -1)
        {
          localObject1 = localObject2;
          if (paramInt < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(paramInt);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return (FileStorageServerListInfo)localObject1;
  }
  
  public ArrayList a(int paramInt)
  {
    int i3 = Integer.MAX_VALUE;
    int i2 = 0;
    ArrayList localArrayList1 = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
    int i;
    int k;
    ArrayList localArrayList2;
    int[] arrayOfInt;
    int j;
    int m;
    int n;
    int i1;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      i = localArrayList1.size();
      k = i;
      if (i >= 3) {
        k = 3;
      }
      localArrayList2 = new ArrayList(k);
      arrayOfInt = a(paramInt);
      if ((arrayOfInt != null) && (arrayOfInt.length == localArrayList1.size()))
      {
        paramInt = 0;
        i = Integer.MAX_VALUE;
        j = 0;
        while (paramInt < arrayOfInt.length)
        {
          m = i;
          if (arrayOfInt[paramInt] < i)
          {
            m = arrayOfInt[paramInt];
            j = paramInt;
          }
          paramInt += 1;
          i = m;
        }
        localArrayList2.add(0, localArrayList1.get(j));
        if (k < 2) {
          break label347;
        }
        paramInt = 0;
        n = Integer.MAX_VALUE;
        for (i = 0; paramInt < arrayOfInt.length; i = m)
        {
          i1 = n;
          m = i;
          if (paramInt != j)
          {
            i1 = n;
            m = i;
            if (arrayOfInt[paramInt] < n)
            {
              i1 = arrayOfInt[paramInt];
              m = paramInt;
            }
          }
          paramInt += 1;
          n = i1;
        }
        localArrayList2.add(1, localArrayList1.get(i));
      }
    }
    for (;;)
    {
      if (k >= 3)
      {
        n = 0;
        k = i3;
        paramInt = i2;
        while (paramInt < arrayOfInt.length)
        {
          i1 = n;
          m = k;
          if (paramInt != j)
          {
            i1 = n;
            m = k;
            if (paramInt != i)
            {
              i1 = n;
              m = k;
              if (arrayOfInt[paramInt] < k)
              {
                m = arrayOfInt[paramInt];
                i1 = paramInt;
              }
            }
          }
          paramInt += 1;
          n = i1;
          k = m;
        }
        localArrayList2.add(2, localArrayList1.get(n));
      }
      return localArrayList2;
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
      }
      return null;
      label347:
      i = 0;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      ArrayList localArrayList = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
      int[] arrayOfInt = a(paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt < localArrayList.size())
        {
          String str = ((FileStorageServerListInfo)localArrayList.get(paramInt)).sIP;
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label116;
          }
          if (arrayOfInt.length > paramInt) {
            arrayOfInt[paramInt] += 1;
          }
        }
        return;
        label116:
        paramInt += 1;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    int k = 0;
    if (paramFileStoragePushFSSvcList != null)
    {
      this.jdField_a_of_type_Array2dOfInt = new int[18][];
      if ((paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[4] = new int[paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vGPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vGPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[2] = new int[paramFileStoragePushFSSvcList.vGPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[1] = new int[paramFileStoragePushFSSvcList.vPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vQzoneProxyServiceList != null) && (paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[3] = new int[paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vUpLoadList != null) && (paramFileStoragePushFSSvcList.vUpLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[0] = new int[paramFileStoragePushFSSvcList.vUpLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vVipEmotionList != null) && (paramFileStoragePushFSSvcList.vVipEmotionList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[5] = new int[paramFileStoragePushFSSvcList.vVipEmotionList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vC2CPicDownList != null) && (paramFileStoragePushFSSvcList.vC2CPicDownList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[11] = new int[paramFileStoragePushFSSvcList.vC2CPicDownList.size()];
      }
      int i = 6;
      int j;
      if (i <= 10)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
      i = 12;
      if (i <= 15)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
      paramFileStoragePushFSSvcList = FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, 17));
      i = k;
      if (paramFileStoragePushFSSvcList != null) {
        i = paramFileStoragePushFSSvcList.size();
      }
      this.jdField_a_of_type_Array2dOfInt[17] = new int[i];
    }
    FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider).a();
  }
  
  int[] a(int paramInt)
  {
    if (this.jdField_a_of_type_Array2dOfInt == null) {
      return null;
    }
    return this.jdField_a_of_type_Array2dOfInt[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */