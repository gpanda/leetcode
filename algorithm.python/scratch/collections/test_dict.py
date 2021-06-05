from collections import OrderedDict
import pprint


class MyClass:
    def __init__(self, a, b):
        self.a = a
        self.b = b


def test_1():
    d = {'c': 3, 'b': 2, 'a': 1}
    pprint.pprint(d)
    print(len(d))
    assert len(d) == 3


def test_2():
    d = OrderedDict()
    d['c'] = 3
    d['b'] = 2
    d['a'] = 1
    pprint.pprint(d)
    print(len(d))
    assert len(d) == 3
    assert d.values() == [3, 2, 1]

def test_3():
    d = OrderedDict()
    d['c'] = 3
    d['b'] = 2
    d['a'] = 1
    # KeyError: 'd'
    # print(d['d'])
    # print("this line cannot be executed")
