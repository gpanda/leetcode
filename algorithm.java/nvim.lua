local map = vim.keymap.set

-- mvn test current class
map('n', '<leader>mt', function()
    local pkg = vim.fn.expand("%:h:t")
    local cls = vim.fn.expand("%:t:r")
    vim.cmd('term mvn test -Dtest="' .. pkg ..'/' .. cls ..'"')
end, {noremap = true, desc = "Run maven tests on the current class."})

-- measure time consumption during tests
map('n', '<leader>mtp', function()
    local pkg = vim.fn.expand("%:h:t")
    local cls = vim.fn.expand("%:t:r")
    vim.cmd('term mvn test -Ddoprofiling="Y" -Dtest="' .. pkg ..'/' .. cls ..'"')
end, {noremap = true, desc = "Run maven tests with profiling on the current class."})

-- mvn test all
map('n', '<leader>mta', function()
    vim.cmd('term mvn test')
end, {noremap = true, desc = "Run maven tests."})

-- mvn clean
map('n', '<leader>mc', function()
    vim.cmd('term mvn clean')
end, {noremap = true, desc = "Run maven cleanup job."})
