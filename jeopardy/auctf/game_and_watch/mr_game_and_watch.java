Classfile /C:/Users/Alma Karasik/Downloads/ctfs/jeopardy/auctf/game_and_watch/mr_game_and_watch.class
  Last modified Apr 4, 2020; size 5357 bytes
  MD5 checksum d3f6f935f08c7e82dbc6ad0293989187
  Compiled from "mr_game_and_watch.java"
public class mr_game_and_watch
  minor version: 0
  major version: 55
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
    #1 = Methodref          #62.#106      // java/lang/Object."<init>":()V
    #2 = Fieldref           #107.#108     // java/lang/System.out:Ljava/io/PrintStream;
    #3 = String             #109          // Welcome to the Land of Interpreted Languages!
    #4 = Methodref          #110.#111     // java/io/PrintStream.println:(Ljava/lang/String;)V
    #5 = String             #112          // If you are used to doing compiled languages this might be a shock... but if you hate assembly this is the place to be!
    #6 = String             #113          // \nUnfortunately, if you hate Java, this may suck...
    #7 = String             #114          // Good luck!\n
    #8 = Methodref          #70.#115      // mr_game_and_watch.crackme:()Z
    #9 = Methodref          #70.#116      // mr_game_and_watch.print_flag:()V
   #10 = Class              #117          // java/util/Scanner
   #11 = Fieldref           #107.#118     // java/lang/System.in:Ljava/io/InputStream;
   #12 = Methodref          #10.#119      // java/util/Scanner."<init>":(Ljava/io/InputStream;)V
   #13 = Methodref          #70.#120      // mr_game_and_watch.crack_1:(Ljava/util/Scanner;)Z
   #14 = Methodref          #70.#121      // mr_game_and_watch.crack_2:(Ljava/util/Scanner;)Z
   #15 = Methodref          #70.#122      // mr_game_and_watch.crack_3:(Ljava/util/Scanner;)Z
   #16 = String             #123          // That's correct!
   #17 = Methodref          #10.#124      // java/util/Scanner.close:()V
   #18 = String             #125          // Nope that's not right!
   #19 = String             #126          // Let's try some hash cracking!! I'll go easy on you the first time. The first hash we are checking is this
   #20 = Fieldref           #70.#127      // mr_game_and_watch.secret_1:Ljava/lang/String;
   #21 = InvokeDynamic      #0:#131       // #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
   #22 = String             #132          // Think you can crack it? If so give me the value that hashes to that!\n\t
   #23 = Methodref          #110.#133     // java/io/PrintStream.print:(Ljava/lang/String;)V
   #24 = Methodref          #10.#134      // java/util/Scanner.nextLine:()Ljava/lang/String;
   #25 = String             #135          // MD5
   #26 = Methodref          #70.#136      // mr_game_and_watch.hash:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   #27 = Methodref          #90.#137      // java/lang/String.compareTo:(Ljava/lang/String;)I
   #28 = String             #138          // Nice work! One down, two to go ...
   #29 = String             #139          // This next one you don't get to see, if you aren't already digging into the class file you may wanna try that out!\n\t
   #30 = String             #140          // SHA1
   #31 = Fieldref           #70.#141      // mr_game_and_watch.secret_2:[I
   #32 = Fieldref           #70.#142      // mr_game_and_watch.key_2:I
   #33 = Methodref          #70.#143      // mr_game_and_watch.decrypt:([II)Ljava/lang/String;
   #34 = String             #144          // Nice work! Here's the last one...\n\t
   #35 = String             #145          // SHA-256
   #36 = Fieldref           #70.#146      // mr_game_and_watch.key_3:I
   #37 = Methodref          #70.#147      // mr_game_and_watch.encrypt:(Ljava/lang/String;I)[I
   #38 = Fieldref           #70.#148      // mr_game_and_watch.secret_3:[I
   #39 = Methodref          #149.#150     // java/util/Arrays.equals:([I[I)Z
   #40 = Methodref          #90.#151      // java/lang/String.length:()I
   #41 = Methodref          #90.#152      // java/lang/String.charAt:(I)C
   #42 = String             #153          //
   #43 = InvokeDynamic      #1:#155       // #1:makeConcatWithConstants:(Ljava/lang/String;C)Ljava/lang/String;
   #44 = String             #156          // flag.txt
   #45 = Class              #157          // java/io/BufferedReader
   #46 = Class              #158          // java/io/FileReader
   #47 = Methodref          #46.#159      // java/io/FileReader."<init>":(Ljava/lang/String;)V
   #48 = Methodref          #45.#160      // java/io/BufferedReader."<init>":(Ljava/io/Reader;)V
   #49 = Methodref          #45.#161      // java/io/BufferedReader.readLine:()Ljava/lang/String;
   #50 = Methodref          #45.#124      // java/io/BufferedReader.close:()V
   #51 = Class              #162          // java/lang/Throwable
   #52 = Methodref          #51.#163      // java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
   #53 = Class              #164          // java/io/IOException
   #54 = String             #165          // Could not find file please notify admin
   #55 = Methodref          #101.#166     // java/security/MessageDigest.getInstance:(Ljava/lang/String;)Ljava/security/MessageDigest;
   #56 = String             #167          // UTF-8
   #57 = Methodref          #90.#168      // java/lang/String.getBytes:(Ljava/lang/String;)[B
   #58 = Methodref          #101.#169     // java/security/MessageDigest.digest:([B)[B
   #59 = Class              #170          // java/lang/StringBuilder
   #60 = Methodref          #59.#171      // java/lang/StringBuilder."<init>":(I)V
   #61 = String             #172          // %02x
   #62 = Class              #173          // java/lang/Object
   #63 = Methodref          #174.#175     // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   #64 = Methodref          #90.#176      // java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
   #65 = Methodref          #59.#177      // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #66 = Methodref          #59.#178      // java/lang/StringBuilder.toString:()Ljava/lang/String;
   #67 = Class              #179          // java/lang/Exception
   #68 = String             #180          // broke
   #69 = String             #181          // d5c67e2fc5f5f155dff8da4bdc914f41
   #70 = Class              #182          // mr_game_and_watch
   #71 = Utf8               secret_1
   #72 = Utf8               Ljava/lang/String;
   #73 = Utf8               secret_2
   #74 = Utf8               [I
   #75 = Utf8               secret_3
   #76 = Utf8               key_2
   #77 = Utf8               I
   #78 = Utf8               key_3
   #79 = Utf8               <init>
   #80 = Utf8               ()V
   #81 = Utf8               Code
   #82 = Utf8               LineNumberTable
   #83 = Utf8               main
   #84 = Utf8               ([Ljava/lang/String;)V
   #85 = Utf8               StackMapTable
   #86 = Utf8               crackme
   #87 = Utf8               ()Z
   #88 = Utf8               crack_1
   #89 = Utf8               (Ljava/util/Scanner;)Z
   #90 = Class              #183          // java/lang/String
   #91 = Utf8               crack_2
   #92 = Utf8               crack_3
   #93 = Utf8               encrypt
   #94 = Utf8               (Ljava/lang/String;I)[I
   #95 = Class              #74           // "[I"
   #96 = Utf8               decrypt
   #97 = Utf8               ([II)Ljava/lang/String;
   #98 = Utf8               print_flag
   #99 = Utf8               hash
  #100 = Utf8               (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
  #101 = Class              #184          // java/security/MessageDigest
  #102 = Class              #185          // "[B"
  #103 = Utf8               <clinit>
  #104 = Utf8               SourceFile
  #105 = Utf8               mr_game_and_watch.java
  #106 = NameAndType        #79:#80       // "<init>":()V
  #107 = Class              #186          // java/lang/System
  #108 = NameAndType        #187:#188     // out:Ljava/io/PrintStream;
  #109 = Utf8               Welcome to the Land of Interpreted Languages!
  #110 = Class              #189          // java/io/PrintStream
  #111 = NameAndType        #190:#191     // println:(Ljava/lang/String;)V
  #112 = Utf8               If you are used to doing compiled languages this might be a shock... but if you hate assembly this is the place to be!
  #113 = Utf8               \nUnfortunately, if you hate Java, this may suck...
  #114 = Utf8               Good luck!\n
  #115 = NameAndType        #86:#87       // crackme:()Z
  #116 = NameAndType        #98:#80       // print_flag:()V
  #117 = Utf8               java/util/Scanner
  #118 = NameAndType        #192:#193     // in:Ljava/io/InputStream;
  #119 = NameAndType        #79:#194      // "<init>":(Ljava/io/InputStream;)V
  #120 = NameAndType        #88:#89       // crack_1:(Ljava/util/Scanner;)Z
  #121 = NameAndType        #91:#89       // crack_2:(Ljava/util/Scanner;)Z
  #122 = NameAndType        #92:#89       // crack_3:(Ljava/util/Scanner;)Z
  #123 = Utf8               That's correct!
  #124 = NameAndType        #195:#80      // close:()V
  #125 = Utf8               Nope that's not right!
  #126 = Utf8               Let's try some hash cracking!! I'll go easy on you the first time. The first hash we are checking is this
  #127 = NameAndType        #71:#72       // secret_1:Ljava/lang/String;
  #128 = Utf8               BootstrapMethods
  #129 = MethodHandle       #6:#196       // invokestatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
  #130 = String             #197          // \t
  #131 = NameAndType        #198:#199     // makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
  #132 = Utf8               Think you can crack it? If so give me the value that hashes to that!\n\t
  #133 = NameAndType        #200:#191     // print:(Ljava/lang/String;)V
  #134 = NameAndType        #201:#202     // nextLine:()Ljava/lang/String;
  #135 = Utf8               MD5
  #136 = NameAndType        #99:#100      // hash:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
  #137 = NameAndType        #203:#204     // compareTo:(Ljava/lang/String;)I
  #138 = Utf8               Nice work! One down, two to go ...
  #139 = Utf8               This next one you don't get to see, if you aren't already digging into the class file you may wanna try that out!\n\t
  #140 = Utf8               SHA1
  #141 = NameAndType        #73:#74       // secret_2:[I
  #142 = NameAndType        #76:#77       // key_2:I
  #143 = NameAndType        #96:#97       // decrypt:([II)Ljava/lang/String;
  #144 = Utf8               Nice work! Here's the last one...\n\t
  #145 = Utf8               SHA-256
  #146 = NameAndType        #78:#77       // key_3:I
  #147 = NameAndType        #93:#94       // encrypt:(Ljava/lang/String;I)[I
  #148 = NameAndType        #75:#74       // secret_3:[I
  #149 = Class              #205          // java/util/Arrays
  #150 = NameAndType        #206:#207     // equals:([I[I)Z
  #151 = NameAndType        #208:#209     // length:()I
  #152 = NameAndType        #210:#211     // charAt:(I)C
  #153 = Utf8
  #154 = String             #212          // 
  #155 = NameAndType        #198:#213     // makeConcatWithConstants:(Ljava/lang/String;C)Ljava/lang/String;
  #156 = Utf8               flag.txt
  #157 = Utf8               java/io/BufferedReader
  #158 = Utf8               java/io/FileReader
  #159 = NameAndType        #79:#191      // "<init>":(Ljava/lang/String;)V
  #160 = NameAndType        #79:#214      // "<init>":(Ljava/io/Reader;)V
  #161 = NameAndType        #215:#202     // readLine:()Ljava/lang/String;
  #162 = Utf8               java/lang/Throwable
  #163 = NameAndType        #216:#217     // addSuppressed:(Ljava/lang/Throwable;)V
  #164 = Utf8               java/io/IOException
  #165 = Utf8               Could not find file please notify admin
  #166 = NameAndType        #218:#219     // getInstance:(Ljava/lang/String;)Ljava/security/MessageDigest;
  #167 = Utf8               UTF-8
  #168 = NameAndType        #220:#221     // getBytes:(Ljava/lang/String;)[B
  #169 = NameAndType        #222:#223     // digest:([B)[B
  #170 = Utf8               java/lang/StringBuilder
  #171 = NameAndType        #79:#224      // "<init>":(I)V
  #172 = Utf8               %02x
  #173 = Utf8               java/lang/Object
  #174 = Class              #225          // java/lang/Integer
  #175 = NameAndType        #226:#227     // valueOf:(I)Ljava/lang/Integer;
  #176 = NameAndType        #228:#229     // format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
  #177 = NameAndType        #230:#231     // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #178 = NameAndType        #232:#202     // toString:()Ljava/lang/String;
  #179 = Utf8               java/lang/Exception
  #180 = Utf8               broke
  #181 = Utf8               d5c67e2fc5f5f155dff8da4bdc914f41
  #182 = Utf8               mr_game_and_watch
  #183 = Utf8               java/lang/String
  #184 = Utf8               java/security/MessageDigest
  #185 = Utf8               [B
  #186 = Utf8               java/lang/System
  #187 = Utf8               out
  #188 = Utf8               Ljava/io/PrintStream;
  #189 = Utf8               java/io/PrintStream
  #190 = Utf8               println
  #191 = Utf8               (Ljava/lang/String;)V
  #192 = Utf8               in
  #193 = Utf8               Ljava/io/InputStream;
  #194 = Utf8               (Ljava/io/InputStream;)V
  #195 = Utf8               close
  #196 = Methodref          #233.#234     // java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
  #197 = Utf8               \t
  #198 = Utf8               makeConcatWithConstants
  #199 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
  #200 = Utf8               print
  #201 = Utf8               nextLine
  #202 = Utf8               ()Ljava/lang/String;
  #203 = Utf8               compareTo
  #204 = Utf8               (Ljava/lang/String;)I
  #205 = Utf8               java/util/Arrays
  #206 = Utf8               equals
  #207 = Utf8               ([I[I)Z
  #208 = Utf8               length
  #209 = Utf8               ()I
  #210 = Utf8               charAt
  #211 = Utf8               (I)C
  #212 = Utf8               
  #213 = Utf8               (Ljava/lang/String;C)Ljava/lang/String;
  #214 = Utf8               (Ljava/io/Reader;)V
  #215 = Utf8               readLine
  #216 = Utf8               addSuppressed
  #217 = Utf8               (Ljava/lang/Throwable;)V
  #218 = Utf8               getInstance
  #219 = Utf8               (Ljava/lang/String;)Ljava/security/MessageDigest;
  #220 = Utf8               getBytes
  #221 = Utf8               (Ljava/lang/String;)[B
  #222 = Utf8               digest
  #223 = Utf8               ([B)[B
  #224 = Utf8               (I)V
  #225 = Utf8               java/lang/Integer
  #226 = Utf8               valueOf
  #227 = Utf8               (I)Ljava/lang/Integer;
  #228 = Utf8               format
  #229 = Utf8               (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
  #230 = Utf8               append
  #231 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #232 = Utf8               toString
  #233 = Class              #235          // java/lang/invoke/StringConcatFactory
  #234 = NameAndType        #198:#239     // makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
  #235 = Utf8               java/lang/invoke/StringConcatFactory
  #236 = Class              #241          // java/lang/invoke/MethodHandles$Lookup
  #237 = Utf8               Lookup
  #238 = Utf8               InnerClasses
  #239 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
  #240 = Class              #242          // java/lang/invoke/MethodHandles
  #241 = Utf8               java/lang/invoke/MethodHandles$Lookup
  #242 = Utf8               java/lang/invoke/MethodHandles
{
  public static java.lang.String secret_1;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC

  public static int[] secret_2;
    descriptor: [I
    flags: ACC_PUBLIC, ACC_STATIC

  public static int[] secret_3;
    descriptor: [I
    flags: ACC_PUBLIC, ACC_STATIC

  public static int key_2;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public static int key_3;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public mr_game_and_watch();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String Welcome to the Land of Interpreted Languages!
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        11: ldc           #5                  // String If you are used to doing compiled languages this might be a shock... but if you hate assembly this is the place to be!
        13: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        19: ldc           #6                  // String \nUnfortunately, if you hate Java, this may suck...
        21: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        24: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        27: ldc           #7                  // String Good luck!\n
        29: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        32: invokestatic  #8                  // Method crackme:()Z
        35: ifeq          41
        38: invokestatic  #9                  // Method print_flag:()V
        41: return
      LineNumberTable:
        line 29: 0
        line 30: 8
        line 33: 16
        line 35: 24
        line 37: 32
        line 38: 38
        line 40: 41
      StackMapTable: number_of_entries = 1
        frame_type = 41 /* same */

  private static boolean crackme();
    descriptor: ()Z
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=3, locals=1, args_size=0
         0: new           #10                 // class java/util/Scanner
         3: dup
         4: getstatic     #11                 // Field java/lang/System.in:Ljava/io/InputStream;
         7: invokespecial #12                 // Method java/util/Scanner."<init>":(Ljava/io/InputStream;)V
        10: astore_0
        11: aload_0
        12: invokestatic  #13                 // Method crack_1:(Ljava/util/Scanner;)Z
        15: ifeq          46
        18: aload_0
        19: invokestatic  #14                 // Method crack_2:(Ljava/util/Scanner;)Z
        22: ifeq          46
        25: aload_0
        26: invokestatic  #15                 // Method crack_3:(Ljava/util/Scanner;)Z
        29: ifeq          46
        32: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        35: ldc           #16                 // String That's correct!
        37: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        40: aload_0
        41: invokevirtual #17                 // Method java/util/Scanner.close:()V
        44: iconst_1
        45: ireturn
        46: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        49: ldc           #18                 // String Nope that's not right!
        51: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        54: aload_0
        55: invokevirtual #17                 // Method java/util/Scanner.close:()V
        58: iconst_0
        59: ireturn
      LineNumberTable:
        line 43: 0
        line 44: 11
        line 45: 32
        line 46: 40
        line 47: 44
        line 50: 46
        line 51: 54
        line 52: 58
      StackMapTable: number_of_entries = 1
        frame_type = 252 /* append */
          offset_delta = 46
          locals = [ class java/util/Scanner ]

  private static boolean crack_1(java.util.Scanner);
    descriptor: (Ljava/util/Scanner;)Z
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #19                 // String Let's try some hash cracking!! I'll go easy on you the first time. The first hash we are checking is this
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        11: getstatic     #20                 // Field secret_1:Ljava/lang/String;
        14: invokedynamic #21,  0             // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
        19: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        22: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        25: ldc           #22                 // String Think you can crack it? If so give me the value that hashes to that!\n\t
        27: invokevirtual #23                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
        30: aload_0
        31: invokevirtual #24                 // Method java/util/Scanner.nextLine:()Ljava/lang/String;
        34: astore_1
        35: aload_1
        36: ldc           #25                 // String MD5
        38: invokestatic  #26                 // Method hash:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        41: astore_2
        42: aload_2
        43: getstatic     #20                 // Field secret_1:Ljava/lang/String;
        46: invokevirtual #27                 // Method java/lang/String.compareTo:(Ljava/lang/String;)I
        49: ifne          56
        52: iconst_1
        53: goto          57
        56: iconst_0
        57: ireturn
      LineNumberTable:
        line 57: 0
        line 59: 8
        line 60: 22
        line 62: 30
        line 64: 35
        line 66: 42
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 56
          locals = [ class java/lang/String, class java/lang/String ]
        frame_type = 64 /* same_locals_1_stack_item */
          stack = [ int ]

  private static boolean crack_2(java.util.Scanner);
    descriptor: (Ljava/util/Scanner;)Z
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=3, locals=2, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #28                 // String Nice work! One down, two to go ...
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        11: ldc           #29                 // String This next one you don't get to see, if you aren't already digging into the class file you may wanna try that out!\n\t
        13: invokevirtual #23                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
        16: aload_0
        17: invokevirtual #24                 // Method java/util/Scanner.nextLine:()Ljava/lang/String;
        20: astore_1
        21: aload_1
        22: ldc           #30                 // String SHA1
        24: invokestatic  #26                 // Method hash:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        27: getstatic     #31                 // Field secret_2:[I
        30: getstatic     #32                 // Field key_2:I
        33: invokestatic  #33                 // Method decrypt:([II)Ljava/lang/String;
        36: invokevirtual #27                 // Method java/lang/String.compareTo:(Ljava/lang/String;)I
        39: ifne          46
        42: iconst_1
        43: goto          47
        46: iconst_0
        47: ireturn
      LineNumberTable:
        line 70: 0
        line 72: 8
        line 74: 16
        line 75: 21
      StackMapTable: number_of_entries = 2
        frame_type = 252 /* append */
          offset_delta = 46
          locals = [ class java/lang/String ]
        frame_type = 64 /* same_locals_1_stack_item */
          stack = [ int ]

  private static boolean crack_3(java.util.Scanner);
    descriptor: (Ljava/util/Scanner;)Z
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=2, locals=4, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #34                 // String Nice work! Here's the last one...\n\t
         5: invokevirtual #23                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
         8: aload_0
         9: invokevirtual #24                 // Method java/util/Scanner.nextLine:()Ljava/lang/String;
        12: astore_1
        13: aload_1
        14: ldc           #35                 // String SHA-256
        16: invokestatic  #26                 // Method hash:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        19: astore_2
        20: aload_2
        21: getstatic     #36                 // Field key_3:I
        24: invokestatic  #37                 // Method encrypt:(Ljava/lang/String;I)[I
        27: astore_3
        28: aload_3
        29: getstatic     #38                 // Field secret_3:[I
        32: invokestatic  #39                 // Method java/util/Arrays.equals:([I[I)Z
        35: ireturn
      LineNumberTable:
        line 80: 0
        line 81: 8
        line 83: 13
        line 84: 20
        line 85: 28

  private static int[] encrypt(java.lang.String, int);
    descriptor: (Ljava/lang/String;I)[I
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=4, locals=4, args_size=2
         0: aload_0
         1: invokevirtual #40                 // Method java/lang/String.length:()I
         4: newarray       int
         6: astore_2
         7: iconst_0
         8: istore_3
         9: iload_3
        10: aload_0
        11: invokevirtual #40                 // Method java/lang/String.length:()I
        14: if_icmpge     33
        17: aload_2
        18: iload_3
        19: aload_0
        20: iload_3
        21: invokevirtual #41                 // Method java/lang/String.charAt:(I)C
        24: iload_1
        25: ixor
        26: iastore
        27: iinc          3, 1
        30: goto          9
        33: aload_2
        34: areturn
      LineNumberTable:
        line 89: 0
        line 91: 7
        line 92: 17
        line 91: 27
        line 100: 33
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 9
          locals = [ class "[I", int ]
        frame_type = 250 /* chop */
          offset_delta = 23

  private static java.lang.String decrypt(int[], int);
    descriptor: ([II)Ljava/lang/String;
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=3, locals=4, args_size=2
         0: ldc           #42                 // String
         2: astore_2
         3: iconst_0
         4: istore_3
         5: iload_3
         6: aload_0
         7: arraylength
         8: if_icmpge     30
        11: aload_2
        12: aload_0
        13: iload_3
        14: iaload
        15: iload_1
        16: ixor
        17: i2c
        18: invokedynamic #43,  0             // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;C)Ljava/lang/String;
        23: astore_2
        24: iinc          3, 1
        27: goto          5
        30: aload_2
        31: areturn
      LineNumberTable:
        line 104: 0
        line 105: 3
        line 106: 11
        line 105: 24
        line 108: 30
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 5
          locals = [ class java/lang/String, int ]
        frame_type = 250 /* chop */
          offset_delta = 24

  private static void print_flag();
    descriptor: ()V
    flags: ACC_PRIVATE, ACC_STATIC
    Code:
      stack=5, locals=4, args_size=0
         0: ldc           #44                 // String flag.txt
         2: astore_0
         3: new           #45                 // class java/io/BufferedReader
         6: dup
         7: new           #46                 // class java/io/FileReader
        10: dup
        11: aload_0
        12: invokespecial #47                 // Method java/io/FileReader."<init>":(Ljava/lang/String;)V
        15: invokespecial #48                 // Method java/io/BufferedReader."<init>":(Ljava/io/Reader;)V
        18: astore_1
        19: aload_1
        20: invokevirtual #49                 // Method java/io/BufferedReader.readLine:()Ljava/lang/String;
        23: dup
        24: astore_2
        25: ifnull        38
        28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        31: aload_2
        32: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        35: goto          19
        38: aload_1
        39: invokevirtual #50                 // Method java/io/BufferedReader.close:()V
        42: goto          61
        45: astore_2
        46: aload_1
        47: invokevirtual #50                 // Method java/io/BufferedReader.close:()V
        50: goto          59
        53: astore_3
        54: aload_2
        55: aload_3
        56: invokevirtual #52                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        59: aload_2
        60: athrow
        61: goto          73
        64: astore_1
        65: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        68: ldc           #54                 // String Could not find file please notify admin
        70: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        73: return
      Exception table:
         from    to  target type
            19    38    45   Class java/lang/Throwable
            46    50    53   Class java/lang/Throwable
             3    61    64   Class java/io/IOException
      LineNumberTable:
        line 112: 0
        line 113: 3
        line 115: 19
        line 116: 28
        line 119: 38
        line 113: 45
        line 121: 61
        line 119: 64
        line 120: 65
        line 122: 73
      StackMapTable: number_of_entries = 8
        frame_type = 253 /* append */
          offset_delta = 19
          locals = [ class java/lang/String, class java/io/BufferedReader ]
        frame_type = 18 /* same */
        frame_type = 70 /* same_locals_1_stack_item */
          stack = [ class java/lang/Throwable ]
        frame_type = 255 /* full_frame */
          offset_delta = 7
          locals = [ class java/lang/String, class java/io/BufferedReader, class java/lang/Throwable ]
          stack = [ class java/lang/Throwable ]
        frame_type = 5 /* same */
        frame_type = 249 /* chop */
          offset_delta = 1
        frame_type = 66 /* same_locals_1_stack_item */
          stack = [ class java/io/IOException ]
        frame_type = 8 /* same */

  public static java.lang.String hash(java.lang.String, java.lang.String);
    descriptor: (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=7, locals=10, args_size=2
         0: aconst_null
         1: astore_2
         2: aload_1
         3: invokestatic  #55                 // Method java/security/MessageDigest.getInstance:(Ljava/lang/String;)Ljava/security/MessageDigest;
         6: astore_3
         7: aload_3
         8: aload_0
         9: ldc           #56                 // String UTF-8
        11: invokevirtual #57                 // Method java/lang/String.getBytes:(Ljava/lang/String;)[B
        14: invokevirtual #58                 // Method java/security/MessageDigest.digest:([B)[B
        17: astore        4
        19: new           #59                 // class java/lang/StringBuilder
        22: dup
        23: iconst_2
        24: aload         4
        26: arraylength
        27: imul
        28: invokespecial #60                 // Method java/lang/StringBuilder."<init>":(I)V
        31: astore        5
        33: aload         4
        35: astore        6
        37: aload         6
        39: arraylength
        40: istore        7
        42: iconst_0
        43: istore        8
        45: iload         8
        47: iload         7
        49: if_icmpge     92
        52: aload         6
        54: iload         8
        56: baload
        57: istore        9
        59: aload         5
        61: ldc           #61                 // String %02x
        63: iconst_1
        64: anewarray     #62                 // class java/lang/Object
        67: dup
        68: iconst_0
        69: iload         9
        71: sipush        255
        74: iand
        75: invokestatic  #63                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        78: aastore
        79: invokestatic  #64                 // Method java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        82: invokevirtual #65                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        85: pop
        86: iinc          8, 1
        89: goto          45
        92: aload         5
        94: invokevirtual #66                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        97: astore_2
        98: goto          110
       101: astore_3
       102: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       105: ldc           #68                 // String broke
       107: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       110: aload_2
       111: areturn
      Exception table:
         from    to  target type
             2    98   101   Class java/lang/Exception
      LineNumberTable:
        line 125: 0
        line 127: 2
        line 128: 7
        line 131: 19
        line 132: 33
        line 133: 59
        line 132: 86
        line 136: 92
        line 139: 98
        line 137: 101
        line 138: 102
        line 141: 110
      StackMapTable: number_of_entries = 4
        frame_type = 255 /* full_frame */
          offset_delta = 45
          locals = [ class java/lang/String, class java/lang/String, class java/lang/String, class java/security/MessageDigest, class "[B", class java/lang/StringBuilder, class "[B", int, int ]
          stack = []
        frame_type = 248 /* chop */
          offset_delta = 46
        frame_type = 255 /* full_frame */
          offset_delta = 8
          locals = [ class java/lang/String, class java/lang/String, class java/lang/String ]
          stack = [ class java/lang/Exception ]
        frame_type = 8 /* same */

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=4, locals=0, args_size=0
         0: ldc           #69                 // String d5c67e2fc5f5f155dff8da4bdc914f41
         2: putstatic     #20                 // Field secret_1:Ljava/lang/String;
         5: bipush        40
         7: newarray       int
         9: dup
        10: iconst_0
        11: bipush        114
        13: iastore
        14: dup
        15: iconst_1
        16: bipush        118
        18: iastore
        19: dup
        20: iconst_2
        21: bipush        116
        23: iastore
        24: dup
        25: iconst_3
        26: bipush        114
        28: iastore
        29: dup
        30: iconst_4
        31: bipush        113
        33: iastore
        34: dup
        35: iconst_5
        36: bipush        114
        38: iastore
        39: dup
        40: bipush        6
        42: bipush        36
        44: iastore
        45: dup
        46: bipush        7
        48: bipush        37
        50: iastore
        51: dup
        52: bipush        8
        54: bipush        38
        56: iastore
        57: dup
        58: bipush        9
        60: bipush        38
        62: iastore
        63: dup
        64: bipush        10
        66: bipush        120
        68: iastore
        69: dup
        70: bipush        11
        72: bipush        121
        74: iastore
        75: dup
        76: bipush        12
        78: bipush        33
        80: iastore
        81: dup
        82: bipush        13
        84: bipush        36
        86: iastore
        87: dup
        88: bipush        14
        90: bipush        37
        92: iastore
        93: dup
        94: bipush        15
        96: bipush        113
        98: iastore
        99: dup
       100: bipush        16
       102: bipush        117
       104: iastore
       105: dup
       106: bipush        17
       108: bipush        118
       110: iastore
       111: dup
       112: bipush        18
       114: bipush        118
       116: iastore
       117: dup
       118: bipush        19
       120: bipush        113
       122: iastore
       123: dup
       124: bipush        20
       126: bipush        33
       128: iastore
       129: dup
       130: bipush        21
       132: bipush        117
       134: iastore
       135: dup
       136: bipush        22
       138: bipush        121
       140: iastore
       141: dup
       142: bipush        23
       144: bipush        37
       146: iastore
       147: dup
       148: bipush        24
       150: bipush        119
       152: iastore
       153: dup
       154: bipush        25
       156: bipush        34
       158: iastore
       159: dup
       160: bipush        26
       162: bipush        118
       164: iastore
       165: dup
       166: bipush        27
       168: bipush        115
       170: iastore
       171: dup
       172: bipush        28
       174: bipush        114
       176: iastore
       177: dup
       178: bipush        29
       180: bipush        120
       182: iastore
       183: dup
       184: bipush        30
       186: bipush        119
       188: iastore
       189: dup
       190: bipush        31
       192: bipush        114
       194: iastore
       195: dup
       196: bipush        32
       198: bipush        36
       200: iastore
       201: dup
       202: bipush        33
       204: bipush        120
       206: iastore
       207: dup
       208: bipush        34
       210: bipush        117
       212: iastore
       213: dup
       214: bipush        35
       216: bipush        120
       218: iastore
       219: dup
       220: bipush        36
       222: bipush        38
       224: iastore
       225: dup
       226: bipush        37
       228: bipush        114
       230: iastore
       231: dup
       232: bipush        38
       234: bipush        35
       236: iastore
       237: dup
       238: bipush        39
       240: bipush        118
       242: iastore
       243: putstatic     #31                 // Field secret_2:[I
       246: bipush        64
       248: newarray       int
       250: dup
       251: iconst_0
       252: sipush        268
       255: iastore
       256: dup
       257: iconst_1
       258: sipush        348
       261: iastore
       262: dup
       263: iconst_2
       264: sipush        347
       267: iastore
       268: dup
       269: iconst_3
       270: sipush        347
       273: iastore
       274: dup
       275: iconst_4
       276: sipush        269
       279: iastore
       280: dup
       281: iconst_5
       282: sipush        256
       285: iastore
       286: dup
       287: bipush        6
       289: sipush        348
       292: iastore
       293: dup
       294: bipush        7
       296: sipush        269
       299: iastore
       300: dup
       301: bipush        8
       303: sipush        256
       306: iastore
       307: dup
       308: bipush        9
       310: sipush        256
       313: iastore
       314: dup
       315: bipush        10
       317: sipush        344
       320: iastore
       321: dup
       322: bipush        11
       324: sipush        271
       327: iastore
       328: dup
       329: bipush        12
       331: sipush        271
       334: iastore
       335: dup
       336: bipush        13
       338: sipush        264
       341: iastore
       342: dup
       343: bipush        14
       345: sipush        266
       348: iastore
       349: dup
       350: bipush        15
       352: sipush        348
       355: iastore
       356: dup
       357: bipush        16
       359: sipush        257
       362: iastore
       363: dup
       364: bipush        17
       366: sipush        266
       369: iastore
       370: dup
       371: bipush        18
       373: sipush        267
       376: iastore
       377: dup
       378: bipush        19
       380: sipush        348
       383: iastore
       384: dup
       385: bipush        20
       387: sipush        269
       390: iastore
       391: dup
       392: bipush        21
       394: sipush        266
       397: iastore
       398: dup
       399: bipush        22
       401: sipush        266
       404: iastore
       405: dup
       406: bipush        23
       408: sipush        344
       411: iastore
       412: dup
       413: bipush        24
       415: sipush        267
       418: iastore
       419: dup
       420: bipush        25
       422: sipush        270
       425: iastore
       426: dup
       427: bipush        26
       429: sipush        267
       432: iastore
       433: dup
       434: bipush        27
       436: sipush        267
       439: iastore
       440: dup
       441: bipush        28
       443: sipush        348
       446: iastore
       447: dup
       448: bipush        29
       450: sipush        349
       453: iastore
       454: dup
       455: bipush        30
       457: sipush        349
       460: iastore
       461: dup
       462: bipush        31
       464: sipush        265
       467: iastore
       468: dup
       469: bipush        32
       471: sipush        349
       474: iastore
       475: dup
       476: bipush        33
       478: sipush        267
       481: iastore
       482: dup
       483: bipush        34
       485: sipush        256
       488: iastore
       489: dup
       490: bipush        35
       492: sipush        269
       495: iastore
       496: dup
       497: bipush        36
       499: sipush        270
       502: iastore
       503: dup
       504: bipush        37
       506: sipush        349
       509: iastore
       510: dup
       511: bipush        38
       513: sipush        268
       516: iastore
       517: dup
       518: bipush        39
       520: sipush        271
       523: iastore
       524: dup
       525: bipush        40
       527: sipush        351
       530: iastore
       531: dup
       532: bipush        41
       534: sipush        349
       537: iastore
       538: dup
       539: bipush        42
       541: sipush        347
       544: iastore
       545: dup
       546: bipush        43
       548: sipush        269
       551: iastore
       552: dup
       553: bipush        44
       555: sipush        349
       558: iastore
       559: dup
       560: bipush        45
       562: sipush        271
       565: iastore
       566: dup
       567: bipush        46
       569: sipush        257
       572: iastore
       573: dup
       574: bipush        47
       576: sipush        269
       579: iastore
       580: dup
       581: bipush        48
       583: sipush        344
       586: iastore
       587: dup
       588: bipush        49
       590: sipush        351
       593: iastore
       594: dup
       595: bipush        50
       597: sipush        265
       600: iastore
       601: dup
       602: bipush        51
       604: sipush        351
       607: iastore
       608: dup
       609: bipush        52
       611: sipush        265
       614: iastore
       615: dup
       616: bipush        53
       618: sipush        271
       621: iastore
       622: dup
       623: bipush        54
       625: sipush        346
       628: iastore
       629: dup
       630: bipush        55
       632: sipush        271
       635: iastore
       636: dup
       637: bipush        56
       639: sipush        266
       642: iastore
       643: dup
       644: bipush        57
       646: sipush        264
       649: iastore
       650: dup
       651: bipush        58
       653: sipush        351
       656: iastore
       657: dup
       658: bipush        59
       660: sipush        349
       663: iastore
       664: dup
       665: bipush        60
       667: sipush        351
       670: iastore
       671: dup
       672: bipush        61
       674: sipush        271
       677: iastore
       678: dup
       679: bipush        62
       681: sipush        266
       684: iastore
       685: dup
       686: bipush        63
       688: sipush        266
       691: iastore
       692: putstatic     #38                 // Field secret_3:[I
       695: bipush        64
       697: putstatic     #32                 // Field key_2:I
       700: sipush        313
       703: putstatic     #36                 // Field key_3:I
       706: return
      LineNumberTable:
        line 16: 0
        line 17: 5
        line 19: 246
        line 24: 695
        line 25: 700
}
SourceFile: "mr_game_and_watch.java"
InnerClasses:
     public static final #237= #236 of #240; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
BootstrapMethods:
  0: #129 invokestatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
    Method arguments:
      #130 \t
  1: #129 invokestatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
    Method arguments:
      #154 
