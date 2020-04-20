#include <openssl/conf.h>
#include <openssl/evp.h>
#include <openssl/err.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>


int main(){
	decrypt();
}


int decrypt(){
		  int v1; // eax
  long aes256; // rax
  long keyThingy; // rbx
  unsigned int v4; // eax
  int v5; // eax
  int len; // [rsp+18h] [rbp-58h]
  int ciphertext_len; // [rsp+1Ch] [rbp-54h]
  void *fileContent; // [rsp+20h] [rbp-50h]
  void *decrypted; // [rsp+28h] [rbp-48h]
  FILE *stream; // [rsp+30h] [rbp-40h]
  size_t fileLength; // [rsp+48h] [rbp-28h]
  long ctx; // [rsp+50h] [rbp-20h]
  unsigned long v16; // [rsp+58h] [rbp-18h]
  
  char target[] = "otherflag.txt";
  char stringCaloc[] = "jmgcgmseonnehdkwpapcygwyabpwqvob";
  stream = fopen(target, "rb");
  len = 0;
  ciphertext_len = 0;
  if ( stream )
  {
    fseek(stream, 0LL, 2);
    fileLength = ftell(stream);
    rewind(stream);
    if ( fileLength )
    {
		fileContent = calloc(fileLength, 1uLL);
		decrypted = calloc(fileLength + 16, 1uLL);
		fread(fileContent, 1uLL, fileLength, stream);
		fclose(stream);
		
		ctx = EVP_CIPHER_CTX_new();
		aes256 = EVP_aes_256_cbc();
		EVP_DecryptInit_ex(ctx, aes256, 0LL, stringCaloc, 0LL);
		EVP_DecryptUpdate(ctx, (char *)decrypted + ciphertext_len, &len, fileContent, (unsigned int)fileLength);
		ciphertext_len += len;
		EVP_DecryptFinal_ex(ctx, (char *)decrypted + len, &len);
		ciphertext_len += len;
		EVP_CIPHER_CTX_free(ctx);
		v4 = strlen(stringCaloc);
		
		stream = fopen(target, "wb");
		fwrite(decrypted, 1uLL, ciphertext_len, stream);
    }
  }
  
   if ( fileContent )
    free(fileContent);
  if ( decrypted )
    free(decrypted);
  fclose(stream);
}

int encrypt(){
	  int v1; // eax
  long aes256; // rax
  long keyThingy; // rbx
  unsigned int v4; // eax
  int v5; // eax
  int len; // [rsp+18h] [rbp-58h]
  int ciphertext_len; // [rsp+1Ch] [rbp-54h]
  void *fileContent; // [rsp+20h] [rbp-50h]
  void *encrypted; // [rsp+28h] [rbp-48h]
  FILE *stream; // [rsp+30h] [rbp-40h]
  size_t fileLength; // [rsp+48h] [rbp-28h]
  long ctx; // [rsp+50h] [rbp-20h]
  unsigned long v16; // [rsp+58h] [rbp-18h]
  
  char target[] = "flag2.txt";
  char stringCaloc[] = "gytxiddopeeaodirlcrsvfczegmuhiop";
  stream = fopen(target, "rb");
  len = 0;
  ciphertext_len = 0;
  if ( stream )
  {
    fseek(stream, 0LL, 2);
    fileLength = ftell(stream);
    rewind(stream);
    if ( fileLength )
    {
      fileContent = calloc(fileLength, 1uLL);
      encrypted = calloc(fileLength + 16, 1uLL);
      fread(fileContent, 1uLL, fileLength, stream);
      fclose(stream);
      if ( memcmp("WANNASMILE", fileContent, 0xAuLL) )
      {
        ctx = EVP_CIPHER_CTX_new();
        aes256 = EVP_aes_256_cbc();
        EVP_EncryptInit_ex(ctx, aes256, 0LL, stringCaloc, 0LL);
        EVP_EncryptUpdate(ctx, (char *)encrypted + ciphertext_len, &len, fileContent, (unsigned int)fileLength);
        ciphertext_len += len;
        EVP_EncryptFinal_ex(ctx, (char *)encrypted + len, &len);
        ciphertext_len += len;
        EVP_CIPHER_CTX_free(ctx);
        v4 = strlen(stringCaloc);
        stream = fopen(target, "wb");
        fwrite(encrypted, 1uLL, ciphertext_len, stream);
      }
    }
  }
  
   if ( fileContent )
    free(fileContent);
  if ( encrypted )
    free(encrypted);
  fclose(stream);
}