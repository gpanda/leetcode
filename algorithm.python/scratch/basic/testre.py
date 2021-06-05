# -*- encoding: utf8 -*-

import re

def test_1():
    print('\n')
    s = u'150019 银华锐进     2   .97'
    SEP = '\s*(?!\s|,)\s*'
    SEP2 = '\s*'
    a = re.split(SEP, s)
    print(a)

