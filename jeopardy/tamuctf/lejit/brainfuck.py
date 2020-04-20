class Brainfuck(object):
    def __init__(self):
        self._offset = 0

    def get_offset(self):
        return self._offset

    def print(self):
        '''
        prints the char in the current offset
        '''

        return '.'

    def write(self):
        '''
        write a char to the current offset
        '''

        return ','

    def backwards(self, count=1):
        '''
        takes the pointer one byte backwards
        '''

        self._offset -= count
        return '<' * count

    def forwards(self, count=1):
        '''
        takes the pointer one byte forwards
        '''

        self._offset += count
        return '>' * count

    def move(self, offset):
        if offset >= 0:
            return self.forwards(offset)
        else:
            return self.backwards(-offset)


    def inc(self, count=1):
        '''
        increment current byte
        '''

        return '+' * count

    def dec(self, count=1):
        '''
        decrement current byte
        '''

        return '-' * count