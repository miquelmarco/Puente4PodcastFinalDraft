let { createApp } = Vue;
createApp({
    data() {
        return {
            featuredEp: [],
            featuredAr: []
        }
    },
    created() {
        axios.get(`/api/episodes/featured`)
        .then(res => {
            this.featuredEp = res.data
        }).catch(err => console.log(err))
        axios.get(`/api/archives/featured`)
        .then(res => {
            this.featuredAr = res.data
        })
    },
    methods: {
    },
    computed: {
    }
}).mount("#app")