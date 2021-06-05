import s1

params_list = [
    ([3, 2, 4],                 6, [1, 2]),
    ([2, 1, 997, -998, 1002],  -1, [2, 3]),
    ([3, 3],                    6, [0, 1]),
    ([-3, -3],                 -6, [0, 1]),
    ([3, 4],                    7, [0, 1]),
    ([4, 3],                    7, [0, 1]),
    ([-4, -3],                 -7, [0, 1]),
    ([-3, -4],                 -7, [0, 1]),
    ([5, 75, 25],             100, [1, 2]),
]

def solution_verify(s, a, t, e):
    assert s.twoSum(a, t) == e

def test_1():
    s = s1.Solution()
    for params in params_list:
        yield solution_verify, s, params[0], params[1], params[2]

