asm4:
push   ebp
mov    ebp,esp
push   ebx
sub    esp,0x10
mov    DWORD [ebp-0x10],0x27d
mov    DWORD [ebp-0xc],0x0
jmp    asm4+27
add    DWORD [ebp-0xc],0x1
mov    edx,DWORD [ebp-0xc]
mov    eax,DWORD [ebp+0x8]
add    eax,edx
movzx  eax,BYTE [eax]
test   al,al
jne    asm4+23
mov    DWORD [ebp-0x8],0x1
jmp    asm4+138
mov    edx,DWORD [ebp-0x8]
mov    eax,DWORD [ebp+0x8]
add    eax,edx
movzx  eax,BYTE [eax]
movsx  edx,al
mov    eax,DWORD [ebp-0x8]
lea    ecx,[eax-0x1]
mov    eax,DWORD [ebp+0x8]
add    eax,ecx
movzx  eax,BYTE [eax]
movsx  eax,al
sub    edx,eax
mov    eax,edx
mov    edx,eax
mov    eax,DWORD [ebp-0x10]
lea    ebx,[edx+eax*1]
mov    eax,DWORD [ebp-0x8]
lea    edx,[eax+0x1]
mov    eax,DWORD [ebp+0x8]
add    eax,edx
movzx  eax,BYTE [eax]
movsx  edx,al
mov    ecx,DWORD [ebp-0x8]
mov    eax,DWORD [ebp+0x8]
add    eax,ecx
movzx  eax,BYTE [eax]
movsx  eax,al
sub    edx,eax
mov    eax,edx
add    eax,ebx
mov    DWORD [ebp-0x10],eax
add    DWORD [ebp-0x8],0x1
mov    eax,DWORD [ebp-0xc]
sub    eax,0x1
cmp    DWORD [ebp-0x8],eax
jl     asm4+51
mov    eax,DWORD [ebp-0x10]
add    esp,0x10
pop    ebx
pop    ebp
ret    

