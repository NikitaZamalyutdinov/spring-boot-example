var show_add_task_panel_button = new Vue({
    el: '#show_add_task_panel',
    data: {
        seen: true
    },
    methods: {
        inverseSeen: function() {
            this.seen = !(this.seen)
        }
    }
})