package com.squareup.okhttp.internal.framed;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Huffman
{
  private static final int[] CODES;
  private static final byte[] CODE_LENGTHS = { 13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26 };
  private static final Huffman INSTANCE = new Huffman();
  private final Node root = new Node();
  
  static
  {
    int[] arrayOfInt = new int['Ā'];
    arrayOfInt[0] = 8184;
    arrayOfInt[1] = 8388568;
    arrayOfInt[2] = 268435426;
    arrayOfInt[3] = 268435427;
    arrayOfInt[4] = 268435428;
    arrayOfInt[5] = 268435429;
    arrayOfInt[6] = 268435430;
    arrayOfInt[7] = 268435431;
    arrayOfInt[8] = 268435432;
    arrayOfInt[9] = 16777194;
    arrayOfInt[10] = 1073741820;
    arrayOfInt[11] = 268435433;
    arrayOfInt[12] = 268435434;
    arrayOfInt[13] = 1073741821;
    arrayOfInt[14] = 268435435;
    arrayOfInt[15] = 268435436;
    arrayOfInt[16] = 268435437;
    arrayOfInt[17] = 268435438;
    arrayOfInt[18] = 268435439;
    arrayOfInt[19] = 268435440;
    arrayOfInt[20] = 268435441;
    arrayOfInt[21] = 268435442;
    arrayOfInt[22] = 1073741822;
    arrayOfInt[23] = 268435443;
    arrayOfInt[24] = 268435444;
    arrayOfInt[25] = 268435445;
    arrayOfInt[26] = 268435446;
    arrayOfInt[27] = 268435447;
    arrayOfInt[28] = 268435448;
    arrayOfInt[29] = 268435449;
    arrayOfInt[30] = 268435450;
    arrayOfInt[31] = 268435451;
    arrayOfInt[32] = 20;
    arrayOfInt[33] = 1016;
    arrayOfInt[34] = 1017;
    arrayOfInt[35] = 4090;
    arrayOfInt[36] = 8185;
    arrayOfInt[37] = 21;
    arrayOfInt[38] = 248;
    arrayOfInt[39] = 2042;
    arrayOfInt[40] = 1018;
    arrayOfInt[41] = 1019;
    arrayOfInt[42] = 249;
    arrayOfInt[43] = 2043;
    arrayOfInt[44] = 250;
    arrayOfInt[45] = 22;
    arrayOfInt[46] = 23;
    arrayOfInt[47] = 24;
    arrayOfInt[49] = 1;
    arrayOfInt[50] = 2;
    arrayOfInt[51] = 25;
    arrayOfInt[52] = 26;
    arrayOfInt[53] = 27;
    arrayOfInt[54] = 28;
    arrayOfInt[55] = 29;
    arrayOfInt[56] = 30;
    arrayOfInt[57] = 31;
    arrayOfInt[58] = 92;
    arrayOfInt[59] = 251;
    arrayOfInt[60] = 32764;
    arrayOfInt[61] = 32;
    arrayOfInt[62] = 4091;
    arrayOfInt[63] = 1020;
    arrayOfInt[64] = 8186;
    arrayOfInt[65] = 33;
    arrayOfInt[66] = 93;
    arrayOfInt[67] = 94;
    arrayOfInt[68] = 95;
    arrayOfInt[69] = 96;
    arrayOfInt[70] = 97;
    arrayOfInt[71] = 98;
    arrayOfInt[72] = 99;
    arrayOfInt[73] = 100;
    arrayOfInt[74] = 101;
    arrayOfInt[75] = 102;
    arrayOfInt[76] = 103;
    arrayOfInt[77] = 104;
    arrayOfInt[78] = 105;
    arrayOfInt[79] = 106;
    arrayOfInt[80] = 107;
    arrayOfInt[81] = 108;
    arrayOfInt[82] = 109;
    arrayOfInt[83] = 110;
    arrayOfInt[84] = 111;
    arrayOfInt[85] = 112;
    arrayOfInt[86] = 113;
    arrayOfInt[87] = 114;
    arrayOfInt[88] = 252;
    arrayOfInt[89] = 115;
    arrayOfInt[90] = 253;
    arrayOfInt[91] = 8187;
    arrayOfInt[92] = 524272;
    arrayOfInt[93] = 8188;
    arrayOfInt[94] = 16380;
    arrayOfInt[95] = 34;
    arrayOfInt[96] = 32765;
    arrayOfInt[97] = 3;
    arrayOfInt[98] = 35;
    arrayOfInt[99] = 4;
    arrayOfInt[100] = 36;
    arrayOfInt[101] = 5;
    arrayOfInt[102] = 37;
    arrayOfInt[103] = 38;
    arrayOfInt[104] = 39;
    arrayOfInt[105] = 6;
    arrayOfInt[106] = 116;
    arrayOfInt[107] = 117;
    arrayOfInt[108] = 40;
    arrayOfInt[109] = 41;
    arrayOfInt[110] = 42;
    arrayOfInt[111] = 7;
    arrayOfInt[112] = 43;
    arrayOfInt[113] = 118;
    arrayOfInt[114] = 44;
    arrayOfInt[115] = 8;
    arrayOfInt[116] = 9;
    arrayOfInt[117] = 45;
    arrayOfInt[118] = 119;
    arrayOfInt[119] = 120;
    arrayOfInt[120] = 121;
    arrayOfInt[121] = 122;
    arrayOfInt[122] = 123;
    arrayOfInt[123] = 32766;
    arrayOfInt[124] = 2044;
    arrayOfInt[125] = 16381;
    arrayOfInt[126] = 8189;
    arrayOfInt[127] = 268435452;
    arrayOfInt[''] = 1048550;
    arrayOfInt[''] = 4194258;
    arrayOfInt[''] = 1048551;
    arrayOfInt[''] = 1048552;
    arrayOfInt[''] = 4194259;
    arrayOfInt[''] = 4194260;
    arrayOfInt[''] = 4194261;
    arrayOfInt[''] = 8388569;
    arrayOfInt[''] = 4194262;
    arrayOfInt[''] = 8388570;
    arrayOfInt[''] = 8388571;
    arrayOfInt[''] = 8388572;
    arrayOfInt[''] = 8388573;
    arrayOfInt[''] = 8388574;
    arrayOfInt[''] = 16777195;
    arrayOfInt[''] = 8388575;
    arrayOfInt[''] = 16777196;
    arrayOfInt[''] = 16777197;
    arrayOfInt[''] = 4194263;
    arrayOfInt[''] = 8388576;
    arrayOfInt[''] = 16777198;
    arrayOfInt[''] = 8388577;
    arrayOfInt[''] = 8388578;
    arrayOfInt[''] = 8388579;
    arrayOfInt[''] = 8388580;
    arrayOfInt[''] = 2097116;
    arrayOfInt[''] = 4194264;
    arrayOfInt[''] = 8388581;
    arrayOfInt[''] = 4194265;
    arrayOfInt[''] = 8388582;
    arrayOfInt[''] = 8388583;
    arrayOfInt[''] = 16777199;
    arrayOfInt[' '] = 4194266;
    arrayOfInt['¡'] = 2097117;
    arrayOfInt['¢'] = 1048553;
    arrayOfInt['£'] = 4194267;
    arrayOfInt['¤'] = 4194268;
    arrayOfInt['¥'] = 8388584;
    arrayOfInt['¦'] = 8388585;
    arrayOfInt['§'] = 2097118;
    arrayOfInt['¨'] = 8388586;
    arrayOfInt['©'] = 4194269;
    arrayOfInt['ª'] = 4194270;
    arrayOfInt['«'] = 16777200;
    arrayOfInt['¬'] = 2097119;
    arrayOfInt['­'] = 4194271;
    arrayOfInt['®'] = 8388587;
    arrayOfInt['¯'] = 8388588;
    arrayOfInt['°'] = 2097120;
    arrayOfInt['±'] = 2097121;
    arrayOfInt['²'] = 4194272;
    arrayOfInt['³'] = 2097122;
    arrayOfInt['´'] = 8388589;
    arrayOfInt['µ'] = 4194273;
    arrayOfInt['¶'] = 8388590;
    arrayOfInt['·'] = 8388591;
    arrayOfInt['¸'] = 1048554;
    arrayOfInt['¹'] = 4194274;
    arrayOfInt['º'] = 4194275;
    arrayOfInt['»'] = 4194276;
    arrayOfInt['¼'] = 8388592;
    arrayOfInt['½'] = 4194277;
    arrayOfInt['¾'] = 4194278;
    arrayOfInt['¿'] = 8388593;
    arrayOfInt['À'] = 67108832;
    arrayOfInt['Á'] = 67108833;
    arrayOfInt['Â'] = 1048555;
    arrayOfInt['Ã'] = 524273;
    arrayOfInt['Ä'] = 4194279;
    arrayOfInt['Å'] = 8388594;
    arrayOfInt['Æ'] = 4194280;
    arrayOfInt['Ç'] = 33554412;
    arrayOfInt['È'] = 67108834;
    arrayOfInt['É'] = 67108835;
    arrayOfInt['Ê'] = 67108836;
    arrayOfInt['Ë'] = 134217694;
    arrayOfInt['Ì'] = 134217695;
    arrayOfInt['Í'] = 67108837;
    arrayOfInt['Î'] = 16777201;
    arrayOfInt['Ï'] = 33554413;
    arrayOfInt['Ð'] = 524274;
    arrayOfInt['Ñ'] = 2097123;
    arrayOfInt['Ò'] = 67108838;
    arrayOfInt['Ó'] = 134217696;
    arrayOfInt['Ô'] = 134217697;
    arrayOfInt['Õ'] = 67108839;
    arrayOfInt['Ö'] = 134217698;
    arrayOfInt['×'] = 16777202;
    arrayOfInt['Ø'] = 2097124;
    arrayOfInt['Ù'] = 2097125;
    arrayOfInt['Ú'] = 67108840;
    arrayOfInt['Û'] = 67108841;
    arrayOfInt['Ü'] = 268435453;
    arrayOfInt['Ý'] = 134217699;
    arrayOfInt['Þ'] = 134217700;
    arrayOfInt['ß'] = 134217701;
    arrayOfInt['à'] = 1048556;
    arrayOfInt['á'] = 16777203;
    arrayOfInt['â'] = 1048557;
    arrayOfInt['ã'] = 2097126;
    arrayOfInt['ä'] = 4194281;
    arrayOfInt['å'] = 2097127;
    arrayOfInt['æ'] = 2097128;
    arrayOfInt['ç'] = 8388595;
    arrayOfInt['è'] = 4194282;
    arrayOfInt['é'] = 4194283;
    arrayOfInt['ê'] = 33554414;
    arrayOfInt['ë'] = 33554415;
    arrayOfInt['ì'] = 16777204;
    arrayOfInt['í'] = 16777205;
    arrayOfInt['î'] = 67108842;
    arrayOfInt['ï'] = 8388596;
    arrayOfInt['ð'] = 67108843;
    arrayOfInt['ñ'] = 134217702;
    arrayOfInt['ò'] = 67108844;
    arrayOfInt['ó'] = 67108845;
    arrayOfInt['ô'] = 134217703;
    arrayOfInt['õ'] = 134217704;
    arrayOfInt['ö'] = 134217705;
    arrayOfInt['÷'] = 134217706;
    arrayOfInt['ø'] = 134217707;
    arrayOfInt['ù'] = 268435454;
    arrayOfInt['ú'] = 134217708;
    arrayOfInt['û'] = 134217709;
    arrayOfInt['ü'] = 134217710;
    arrayOfInt['ý'] = 134217711;
    arrayOfInt['þ'] = 134217712;
    arrayOfInt['ÿ'] = 67108846;
    CODES = arrayOfInt;
  }
  
  private Huffman()
  {
    buildTree();
  }
  
  private void addCode(int paramInt1, int paramInt2, byte paramByte)
  {
    Node localNode2 = new Node(paramInt1, paramByte);
    Node localNode1 = this.root;
    if (paramByte <= 8)
    {
      paramByte = 8 - paramByte;
      paramInt2 = paramInt2 << paramByte & 0xFF;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2 + (1 << paramByte))
      {
        return;
        paramByte = (byte)(paramByte - 8);
        paramInt1 = paramInt2 >>> paramByte & 0xFF;
        if (localNode1.children == null) {
          throw new IllegalStateException("invalid dictionary: prefix not unique");
        }
        if (localNode1.children[paramInt1] == null) {
          localNode1.children[paramInt1] = new Node();
        }
        localNode1 = localNode1.children[paramInt1];
        break;
      }
      localNode1.children[paramInt1] = localNode2;
      paramInt1 += 1;
    }
  }
  
  private void buildTree()
  {
    int i = 0;
    for (;;)
    {
      if (i >= CODE_LENGTHS.length) {
        return;
      }
      addCode(i, CODES[i], CODE_LENGTHS[i]);
      i += 1;
    }
  }
  
  public static Huffman get()
  {
    return INSTANCE;
  }
  
  byte[] decode(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Node localNode = this.root;
    int k = 0;
    int i = 0;
    int j = 0;
    if (j >= paramArrayOfByte.length) {}
    for (;;)
    {
      if (i <= 0) {}
      do
      {
        return localByteArrayOutputStream.toByteArray();
        k = k << 8 | paramArrayOfByte[j] & 0xFF;
        i += 8;
        for (;;)
        {
          if (i < 8)
          {
            j += 1;
            break;
          }
          localNode = localNode.children[(k >>> i - 8 & 0xFF)];
          if (localNode.children == null)
          {
            localByteArrayOutputStream.write(localNode.symbol);
            i -= localNode.terminalBits;
            localNode = this.root;
          }
          else
          {
            i -= 8;
          }
        }
        paramArrayOfByte = localNode.children[(k << 8 - i & 0xFF)];
      } while ((paramArrayOfByte.children != null) || (paramArrayOfByte.terminalBits > i));
      localByteArrayOutputStream.write(paramArrayOfByte.symbol);
      i -= paramArrayOfByte.terminalBits;
      localNode = this.root;
    }
  }
  
  void encode(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    int i = 0;
    int j = 0;
    if (j >= paramArrayOfByte.length)
    {
      if (i > 0) {
        paramOutputStream.write((int)(l << 8 - i | 255 >>> i));
      }
      return;
    }
    int m = paramArrayOfByte[j] & 0xFF;
    int k = CODES[m];
    m = CODE_LENGTHS[m];
    l = l << m | k;
    i += m;
    for (;;)
    {
      if (i < 8)
      {
        j += 1;
        break;
      }
      i -= 8;
      paramOutputStream.write((int)(l >> i));
    }
  }
  
  int encodedLength(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return (int)(7L + l >> 3);
      }
      int j = paramArrayOfByte[i];
      l += CODE_LENGTHS[(j & 0xFF)];
      i += 1;
    }
  }
  
  private static final class Node
  {
    private final Node[] children;
    private final int symbol;
    private final int terminalBits;
    
    Node()
    {
      this.children = new Node['Ā'];
      this.symbol = 0;
      this.terminalBits = 0;
    }
    
    Node(int paramInt1, int paramInt2)
    {
      this.children = null;
      this.symbol = paramInt1;
      paramInt2 &= 0x7;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 8;
      }
      this.terminalBits = paramInt1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\framed\Huffman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */